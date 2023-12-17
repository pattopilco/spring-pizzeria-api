package tech.espoch.pizzeria.controller;

import org.springframework.web.bind.annotation.RestController;

import tech.espoch.pizzeria.persistence.entity.PizzaEntity;
import tech.espoch.pizzeria.service.PizzaService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping()
    public ResponseEntity<List<PizzaEntity>> getAll() {
        return ResponseEntity.ok(pizzaService.getAll());
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> get(@PathVariable int idPizza) {
        return ResponseEntity.ok(pizzaService.get(idPizza));
    }
    
    
}
