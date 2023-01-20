package az.spring.demo.service.impl;

import az.spring.demo.dto.CustomerDto;
import az.spring.demo.entity.Customer;
import az.spring.demo.exception.UserNotFoundException;
import az.spring.demo.repository.CustomerRepository;
import az.spring.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(this::convertDoDtoCustomer)
                .collect(Collectors.toList());
    }


    @Override
    public void insertCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setSurname(customerDto.getSurname());
        customer.setAge(customerDto.getAge());
        customer.setPhone(customerDto.getPhone());
        customer.setCity(customerDto.getCity());
        customer.setEmail(customerDto.getEmail());
        customerRepository.save(customer);
    }

    @Override
    public CustomerDto getById(Long id) throws UserNotFoundException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user not found with id : " + id));
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setSurname(customer.getSurname());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getPhone());
        customerDto.setCity(customer.getCity());
        customerDto.setAge(customer.getAge());
        return customerDto;
    }

    private CustomerDto convertDoDtoCustomer(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setSurname(customer.getSurname());
        customerDto.setAge(customer.getAge());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getPhone());
        customerDto.setCity(customer.getCity());
        return customerDto;
    }

}
