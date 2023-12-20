package tech.espoch.pizzeria.persistence.repository;

import org.springframework.data.repository.ListPagingAndSortingRepository;
import tech.espoch.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<PizzaEntity, Integer>{

    Page<PizzaEntity> findByAvailableTrue(Pageable pageable);
    
}
