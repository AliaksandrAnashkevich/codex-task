package com.codex.repository;

import com.codex.entity.Item;
import com.codex.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item getById(Long id);

    boolean existsByName(String name);

    boolean existsByNameIsAndIdNot(String name, Long id);

    List<Item> getAllByUsers(User user);

    @Modifying
    @Query(value = "INSERT INTO item_users(item_id, users_id) VALUES (:itemId, :userId)", nativeQuery = true)
    void addItemConnection(@Param("itemId") Long itemId, @Param("userId") Long userId);

    @Modifying
    @Query(value = "DELETE FROM item_users WHERE item_id=:id", nativeQuery = true)
    void deleteItemConnection(@Param("id") Long id);

    @Modifying
    @Query(value = "DELETE FROM item_users WHERE users_id=:id", nativeQuery = true)
    void deleteUsersById(@Param("id") Long id);

    @Query("FROM Item i WHERE i.tag LIKE %:tag%")
    List<Item> getByTagPart(@Param("tag") String tag);

    @Query("FROM Item i WHERE i.description LIKE %:description%")
    List<Item> getByDescriptionPart(@Param("description") String description);
}
