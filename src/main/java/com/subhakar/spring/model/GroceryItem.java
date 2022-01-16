package com.subhakar.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@RequiredArgsConstructor
@Document(collection = "grocery_items")
public class GroceryItem {
    private final String id;
    private final String name;
    private final int quantity;
    private final String category;
}
