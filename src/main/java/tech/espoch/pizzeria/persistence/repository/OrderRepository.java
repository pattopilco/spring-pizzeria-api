package tech.espoch.pizzeria.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import tech.espoch.pizzeria.persistence.entity.OrderEntity;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer>{
    
}
