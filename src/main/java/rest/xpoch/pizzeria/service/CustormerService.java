package rest.xpoch.pizzeria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.xpoch.pizzeria.persistence.entity.CustomerEntity;
import rest.xpoch.pizzeria.persistence.repository.CustomerRepository;

@Service
public class CustormerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerEntity findByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }
}
