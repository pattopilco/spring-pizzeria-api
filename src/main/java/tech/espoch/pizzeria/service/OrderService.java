package tech.espoch.pizzeria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.espoch.pizzeria.persistence.entity.OrderEntity;
import tech.espoch.pizzeria.persistence.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderEntity> getAll() {
        return this.orderRepository.findAll();
    }
    
}
