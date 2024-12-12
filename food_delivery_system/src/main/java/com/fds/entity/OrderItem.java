package com.fds.entity;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_order_id", nullable = false)
    private FoodOrder foodOrder; // Reference to FoodOrder entity

    @ManyToOne
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem; // Reference to MenuItem entity

    private int quantity;
    private double price;

    // Default Constructor
    public OrderItem() {}

    // Constructor to initialize OrderItem
    public OrderItem(FoodOrder foodOrder, MenuItem menuItem, int quantity) {
        this.foodOrder = foodOrder;
        this.menuItem = menuItem;
        this.quantity = quantity;
        
        // Ensure the menuItem is not null and has a valid price
        if (menuItem != null) {
            this.price = menuItem.getPrice() * quantity; // Calculate price based on menuItem's price
        } else {
            this.price = 0.0; // Set default price to 0 if menuItem is null
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FoodOrder getFoodOrder() {
        return foodOrder;
    }

    public void setFoodOrder(FoodOrder foodOrder) {
        this.foodOrder = foodOrder;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
        // Recalculate price when the menuItem is set
        if (menuItem != null) {
            this.price = menuItem.getPrice() * this.quantity;
        } else {
            this.price = 0.0; // Handle null case
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        // Recalculate price when the quantity is set
        if (menuItem != null) {
            this.price = menuItem.getPrice() * quantity;
        } else {
            this.price = 0.0; // Handle null case
        }
    }

    public double getPrice() {
        return price;
    }

    // toString method
    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", foodOrder=" + foodOrder.getId() + // assuming getId() is in FoodOrder
                ", menuItem=" + (menuItem != null ? menuItem.getId() : "null") + // assuming getId() is in MenuItem
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
