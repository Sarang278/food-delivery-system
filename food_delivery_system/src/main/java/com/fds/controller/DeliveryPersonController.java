package com.fds.controller;

import com.fds.entity.DeliveryPerson;
import com.fds.service.DeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery-persons")
public class DeliveryPersonController {

    @Autowired
    private DeliveryPersonService deliveryPersonService;

    @PostMapping
    public ResponseEntity<DeliveryPerson> createDeliveryPerson(@RequestBody DeliveryPerson deliveryPerson) {
        DeliveryPerson createdDeliveryPerson = deliveryPersonService.saveDeliveryPerson(deliveryPerson);
        return new ResponseEntity<>(createdDeliveryPerson, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DeliveryPerson>> getAllDeliveryPersons() {
        List<DeliveryPerson> deliveryPersons = deliveryPersonService.getAllDeliveryPersons();
        return new ResponseEntity<>(deliveryPersons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryPerson> getDeliveryPersonById(@PathVariable Long id) {
        DeliveryPerson deliveryPerson = deliveryPersonService.getDeliveryPersonById(id);
        return new ResponseEntity<>(deliveryPerson, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryPerson> updateDeliveryPerson(@PathVariable Long id, @RequestBody DeliveryPerson deliveryPerson) {
        DeliveryPerson updatedDeliveryPerson = deliveryPersonService.updateDeliveryPerson(id, deliveryPerson);
        return new ResponseEntity<>(updatedDeliveryPerson, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliveryPerson(@PathVariable Long id) {
        deliveryPersonService.deleteDeliveryPerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
