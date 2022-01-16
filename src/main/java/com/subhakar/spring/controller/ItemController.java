package com.subhakar.spring.controller;

import com.subhakar.spring.model.GroceryItem;
import com.subhakar.spring.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/items")
    public ResponseEntity<GroceryItem> saveGroceryItem(@RequestBody GroceryItem groceryItem) {
        return new ResponseEntity<>(itemService.saveGroceryItem(groceryItem), HttpStatus.CREATED);
    }


    @GetMapping(value = "/items", params = "name")
    public ResponseEntity<GroceryItem> getGroceryItemByName(@RequestParam String name) {
        return ResponseEntity.ok(itemService.getGroceryItemByName(name));
    }

    @GetMapping(value = "/items", params = "category")
    public ResponseEntity<List<GroceryItem>> getGroceryItemByCategory(@RequestParam String category) {
        return ResponseEntity.ok(itemService.getGroceryItemsByCategory(category));
    }

    @GetMapping("/items")
    public ResponseEntity<List<GroceryItem>> getGroceryItems() {
        return ResponseEntity.ok(itemService.getGroceryItems());
    }
}
