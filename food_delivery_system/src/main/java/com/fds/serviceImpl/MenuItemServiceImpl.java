package com.fds.serviceImpl;


import com.fds.entity.MenuItem;
import com.fds.repository.MenuItemRepository;
import com.fds.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    @Override
    public MenuItem updateMenuItem(Long id, MenuItem menuItem) {
        if (menuItemRepository.existsById(id)) {
            menuItem.setId(id);
            return menuItemRepository.save(menuItem);
        }
        return null;
    }

    @Override
    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }
}
