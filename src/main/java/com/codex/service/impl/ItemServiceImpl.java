package com.codex.service.impl;

import com.codex.entity.Item;
import com.codex.repository.ItemRepository;
import com.codex.repository.UserRepository;
import com.codex.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private UserRepository userRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Item getById(Long id) {
        return itemRepository.getById(id);
    }

    @Override
    public List<Item> getByUser(String username) {
        return itemRepository.getAllByUsers(userRepository.findByUsername(username));
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> getByTag(String tag) {
        return itemRepository.getByTagPart(tag);
    }

    @Override
    public List<Item> getByDescription(String description) {
        return itemRepository.getByDescriptionPart(description);
    }

    @Override
    public void save(Item item) {
        if (itemRepository.existsByName(item.getName())) {
            //throw new EntityIsAlreadyExistException("city with name " + cityDto.getName() + " is already exist.");
            System.out.println("error");
        } else {
            itemRepository.save(item);
        }
    }

    @Override
    public void update(Item item) {
        if (itemRepository.existsById(item.getId())) {
            if (itemRepository.existsByNameIsAndIdNot(item.getName(), item.getId())) {
                System.out.println("error");
                //throw new EntityIsAlreadyExistException("city with name " + cityDto.getName() + " is already exist.");
            }
            itemRepository.save(item);
        } else {
            System.out.println("error");
            //throw new EntityIsNotExistException(CITY_IS_NOT_EXIST);
        }
    }

    @Override
    public void delete(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.delete(itemRepository.getById(id));
        } else {
            System.out.println("error");
        }

    }

    @Transactional
    @Override
    public void addItemConnection(Long itemId, Long userId) {
        itemRepository.addItemConnection(itemId, userId);
    }

    @Transactional
    @Override
    public void deleteItemConnection(Long id) {
        itemRepository.deleteItemConnection(id);
    }

    @Transactional
    @Override
    public void deleteConnection(Long id) {
        itemRepository.deleteUsersById(id);
    }
}
