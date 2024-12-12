package com.fds.service;

import com.fds.entity.DeliveryPerson;
import java.util.List;

public interface DeliveryPersonService {
    DeliveryPerson saveDeliveryPerson(DeliveryPerson deliveryPerson);
    List<DeliveryPerson> getAllDeliveryPersons();
    DeliveryPerson getDeliveryPersonById(Long id);
    DeliveryPerson updateDeliveryPerson(Long id, DeliveryPerson deliveryPerson);
    void deleteDeliveryPerson(Long id);
}
