package com.codex.service;

import com.codex.entity.Item;

import java.util.List;

public interface ItemService {

    Item getById(Long id);

    List<Item> getByUser(String username);

    List<Item> getAll();

    List<Item> getByTag(String tag);

    List<Item> getByDescription(String description);

    void save(Item item);

    void update(Item item);

    void delete(Long id);

    void addItemConnection(Long itemId, Long userId);

    void deleteItemConnection(Long id);

    void deleteConnection(Long id);
}
