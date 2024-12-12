package com.fds.serviceImpl;

import com.fds.entity.FoodOrder;
import com.fds.repository.FoodOrderRepository; // Assuming you have a repository
import com.fds.service.FoodOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {

    @Autowired
    private FoodOrderRepository orderRepository;

    @Override
    public FoodOrder saveOrder(FoodOrder order) {
        return orderRepository.save(order);
    }

    @Override
    public List<FoodOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public FoodOrder getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public FoodOrder updateOrder(Long id, FoodOrder order) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
