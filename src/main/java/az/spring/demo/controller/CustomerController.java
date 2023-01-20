package az.spring.demo.controller;

import az.spring.demo.dto.CustomerDto;
import az.spring.demo.exception.UserNotFoundException;
import az.spring.demo.service.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {


    private final CustomerServiceImpl customerService;


    @GetMapping("/showAllCustomers")
    private List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    @PostMapping("/saveCustomer")
    private void insertCustomer(@RequestBody @Valid CustomerDto customerDto) {
        customerService.insertCustomer(customerDto);
    }


    @GetMapping("/customerById/{id}")
    private CustomerDto getById(@PathVariable Long id) throws UserNotFoundException {
        return customerService.getById(id);
    }
}
