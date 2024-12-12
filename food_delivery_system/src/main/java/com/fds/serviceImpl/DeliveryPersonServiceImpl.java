package com.fds.serviceImpl;

import com.fds.entity.DeliveryPerson;
import com.fds.repository.DeliveryPersonRepository; // Ensure this exists
import com.fds.service.DeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryPersonServiceImpl implements DeliveryPersonService {

    @Autowired
    private DeliveryPersonRepository deliveryPersonRepository;

    @Override
    public DeliveryPerson saveDeliveryPerson(DeliveryPerson deliveryPerson) {
        return deliveryPersonRepository.save(deliveryPerson);
    }

    @Override
    public List<DeliveryPerson> getAllDeliveryPersons() {
        return deliveryPersonRepository.findAll();
    }

    @Override
    public DeliveryPerson getDeliveryPersonById(Long id) {
        return deliveryPersonRepository.findById(id).orElse(null);
    }

    @Override
    public DeliveryPerson updateDeliveryPerson(Long id, DeliveryPerson deliveryPerson) {
        deliveryPerson.setId(id);
        return deliveryPersonRepository.save(deliveryPerson);
    }

    @Override
    public void deleteDeliveryPerson(Long id) {
        deliveryPersonRepository.deleteById(id);
    }
}
