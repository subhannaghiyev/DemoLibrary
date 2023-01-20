package az.spring.demo.controller;

import az.spring.demo.dto.*;
import az.spring.demo.exception.UserNotFoundException;
import az.spring.demo.service.AuthorService;
import az.spring.demo.service.CustomerService;
import az.spring.demo.service.impl.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class LibraryController {

    private final LibrarianServiceImpl librarianService;

    private final AuthorServiceImpl authorService;


    private final CustomerServiceImpl customerService;


    @GetMapping("/showAllCustomers")
    private List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }







    @PostMapping("/saveLibrarian")
    private void insertLibrarian(@RequestBody LibrarianDto librarianDto) {
        librarianService.insertLibrarian(librarianDto);
    }

    @PostMapping("/saveAuthor")
    private void insertAuthor(@RequestBody AuthorDto authorDto) {
        authorService.insertAuthor(authorDto);
    }



    @PostMapping("/saveCustomer")
    private void insertCustomer(@RequestBody @Valid CustomerDto customerDto) {
        customerService.insertCustomer(customerDto);
    }



    @GetMapping("showAllLibrarian")
    private List<LibrarianDto> getAllLibrarian() {
        return librarianService.getAllLibrarian();
    }

    @GetMapping("/customerById/{id}")
    private CustomerDto getById(@PathVariable Long id) throws UserNotFoundException {
        return customerService.getById(id);
    }

}

