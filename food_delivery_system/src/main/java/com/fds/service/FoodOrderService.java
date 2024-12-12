package com.fds.service;


import com.fds.entity.FoodOrder;
import java.util.List;

public interface FoodOrderService {
    FoodOrder saveOrder(FoodOrder order);
    List<FoodOrder> getAllOrders();
    FoodOrder getOrderById(Long id);
    FoodOrder updateOrder(Long id, FoodOrder order);
    void deleteOrder(Long id);
}
