package az.spring.demo.service;

import az.spring.demo.dto.CustomerDto;
import az.spring.demo.exception.UserNotFoundException;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();

    void insertCustomer(CustomerDto customerDto);

    CustomerDto getById(Long id) throws UserNotFoundException;
}
