package com.subhakar.spring.repository;

public interface CustomItemRepository {
    void updateItemQuantity(String name, int newQuantity);
}
