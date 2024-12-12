package com.fds.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class DeliveryPerson {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @Column(name = "vehicle_type")
    private String vehicleType;

    private String contactNumber;

    @OneToMany(mappedBy = "deliveryPerson") // Link to FoodOrder
    private List<FoodOrder> assignedOrders; // List of assigned orders

    // Default Constructor
    public DeliveryPerson() {}

    // Constructor including all fields
    public DeliveryPerson(String name, String vehicleType, String contactNumber) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.contactNumber = contactNumber; // Initialize contactNumber
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<FoodOrder> getAssignedOrders() {
        return assignedOrders;
    }

    public void setAssignedOrders(List<FoodOrder> assignedOrders) {
        this.assignedOrders = assignedOrders;
    }

    // toString method
    @Override
    public String toString() {
        return "DeliveryPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
