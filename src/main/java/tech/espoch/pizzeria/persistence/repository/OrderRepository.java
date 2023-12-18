package tech.espoch.pizzeria.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import tech.espoch.pizzeria.persistence.entity.OrderEntity;
import java.util.List;
import java.time.LocalDateTime;


public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer>{
    List<OrderEntity> findAllByDateAfter(LocalDateTime date);
    List<OrderEntity> findAllByMethodIn(List<String> methods);
}
