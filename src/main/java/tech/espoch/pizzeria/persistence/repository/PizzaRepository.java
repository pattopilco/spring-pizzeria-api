package tech.espoch.pizzeria.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import tech.espoch.pizzeria.persistence.entity.PizzaEntity;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer>{
    
}
