package com.fds.entity;

import jakarta.persistence.*;

@Entity
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Reference to User entity

    @ManyToOne
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem; // Reference to MenuItem entity

    @ManyToOne // Add this relationship
    @JoinColumn(name = "delivery_person_id", nullable = false)
    private DeliveryPerson deliveryPerson; // Reference to DeliveryPerson entity

    private int quantity;
    private double totalPrice;

    // Constructors
    public FoodOrder() {}

    public FoodOrder(User user, MenuItem menuItem, DeliveryPerson deliveryPerson, int quantity, double totalPrice) {
        this.user = user;
        this.menuItem = menuItem;
        this.deliveryPerson = deliveryPerson; // Initialize deliveryPerson
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public DeliveryPerson getDeliveryPerson() { // Add this getter
        return deliveryPerson;
    }

    public void setDeliveryPerson(DeliveryPerson deliveryPerson) { // Add this setter
        this.deliveryPerson = deliveryPerson;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // toString method
    @Override
    public String toString() {
        return "FoodOrder{" +
                "id=" + id +
                ", user=" + user.getUsername() + // assuming getUsername() is in User
                ", menuItem=" + menuItem.getName() + // assuming getName() is in MenuItem
                ", deliveryPerson=" + (deliveryPerson != null ? deliveryPerson.getName() : "none") + // assuming getName() is in DeliveryPerson
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
