package com.subhakar.spring.repository;

import com.mongodb.client.result.UpdateResult;
import com.subhakar.spring.model.GroceryItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomItemRepositoryImpl implements CustomItemRepository {
    private final MongoTemplate mongoTemplate;

    @Override
    public void updateItemQuantity(String name, int newQuantity) {
        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update();
        update.set("quantity", newQuantity);
        UpdateResult result = mongoTemplate.updateFirst(query, update, GroceryItem.class);
        if (result == null) {
            log.info("No documents updated");
        } else {
            log.info("{} documents updated", result.getModifiedCount());
        }
    }
}
