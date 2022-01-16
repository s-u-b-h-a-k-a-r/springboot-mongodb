package com.subhakar.spring.service;

import com.subhakar.spring.model.GroceryItem;

import java.util.List;

public interface ItemService {
    GroceryItem getGroceryItemByName(String name);

    List<GroceryItem> getGroceryItemsByCategory(String category);

    List<GroceryItem> getGroceryItems();

    GroceryItem saveGroceryItem(GroceryItem groceryItem);
}
