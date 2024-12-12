package com.fds.service;


import com.fds.entity.MenuItem;
import java.util.List;

public interface MenuItemService {
    MenuItem saveMenuItem(MenuItem menuItem);
    List<MenuItem> getAllMenuItems();
    MenuItem getMenuItemById(Long id);
    MenuItem updateMenuItem(Long id, MenuItem menuItem);
    void deleteMenuItem(Long id);
}
