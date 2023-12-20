package tech.espoch.pizzeria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.espoch.pizzeria.persistence.entity.CustomerEntity;
import tech.espoch.pizzeria.persistence.repository.CustomerRepository;

@Service
public class CustormerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerEntity findByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }
}
