package tech.espoch.pizzeria.service;

import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.espoch.pizzeria.persistence.entity.OrderEntity;
import tech.espoch.pizzeria.persistence.repository.OrderRepository;

@Service
public class OrderService {

    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SITE = "S";


    @Autowired
    private OrderRepository orderRepository;

    public List<OrderEntity> getAll() {
        return this.orderRepository.findAll();
    }

    public List<OrderEntity> getTodayOrders() {
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return this.orderRepository.findAllByDateAfter(today);
    }

    public List<OrderEntity> getOutsideOrders(){
        List<String> methods = Arrays.asList(DELIVERY, CARRYOUT);
        return this.orderRepository.findAllByMethodIn(methods);
    }

    public List<OrderEntity> getCustomerOrders(String idCustomer) {
        return this.orderRepository.getCustomerOrders(idCustomer);
    }
    
}
