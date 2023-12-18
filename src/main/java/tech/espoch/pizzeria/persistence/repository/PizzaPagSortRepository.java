package tech.espoch.pizzeria.persistence.repository;

import org.springframework.data.repository.ListPagingAndSortingRepository;
import tech.espoch.pizzeria.persistence.entity.PizzaEntity;

public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<PizzaEntity, Integer>{
    
}
