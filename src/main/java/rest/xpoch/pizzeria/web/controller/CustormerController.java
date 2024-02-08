package rest.xpoch.pizzeria.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.xpoch.pizzeria.persistence.entity.CustomerEntity;
import rest.xpoch.pizzeria.service.CustormerService;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/customers")
public class CustormerController {

    @Autowired
    private CustormerService custormerService;

    @GetMapping("/phone/{phone}")
    public ResponseEntity<CustomerEntity> getByPhone(@PathVariable("phone") String phone) {
        return ResponseEntity.ok(custormerService.findByPhone(phone));
    }
    
}
