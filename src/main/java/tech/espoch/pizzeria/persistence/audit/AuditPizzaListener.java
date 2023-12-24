package tech.espoch.pizzeria.persistence.audit;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.util.SerializationUtils;
import tech.espoch.pizzeria.persistence.entity.PizzaEntity;
import tech.espoch.pizzeria.service.PizzaService;

public class AuditPizzaListener {

    private PizzaEntity pizzaCurrent;
    @PostLoad
    public void postLoad(PizzaEntity pizzaEntity){
        this.pizzaCurrent = SerializationUtils.clone(pizzaEntity);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(PizzaEntity pizzaEntity) {

    }


    @PreRemove
    public void onPreDelete(PizzaEntity pizzaEntity){

    }
}
