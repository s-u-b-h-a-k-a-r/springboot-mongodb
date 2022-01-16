package com.subhakar.spring;

import com.github.javafaker.Faker;
import com.subhakar.spring.model.GroceryItem;
import com.subhakar.spring.repository.CustomItemRepository;
import com.subhakar.spring.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final ItemService itemService;
    private final CustomItemRepository customItemRepository;

    @Override
    public void run(String... args) {
        saveItems();
        printItems();
        updateItems();
        printItems();
    }

    private void updateItems() {
        customItemRepository.updateItemQuantity("Maudite", 100);
    }

    private void printItems() {
        itemService.getGroceryItems().stream().forEach(System.out::println);
    }

    private void saveItems() {
        IntStream.range(1, 100).forEach(i ->
                itemService.saveGroceryItem(getFakeItem(new Faker()))
        );
    }

    private GroceryItem getFakeItem(Faker faker) {
        return GroceryItem.builder()
                .id(faker.beer().hop())
                .quantity(10)
                .name(faker.beer().name())
                .category(faker.beer().style())
                .build();
    }
}
