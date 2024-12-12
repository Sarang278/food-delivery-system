package com.fds.repository;


import com.fds.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    // Additional query methods can be defined here if needed
}
