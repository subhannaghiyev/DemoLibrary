package az.spring.demo.controller;


import az.spring.demo.dto.BorrowerDto;
import az.spring.demo.service.impl.BorrowerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/borrowers")
public class BorrowerController {
    private final BorrowerServiceImpl borrowerService;

    @PostMapping("/saveBorrower")
    private void insertBorrower(@RequestBody BorrowerDto borrowerDto) {
        borrowerService.insertBorrower(borrowerDto);

    }

    @GetMapping("/showAllBorrowers")
    private List<BorrowerDto> getAllBorrowers() {
        return borrowerService.getAllBorrowers();
    }
}
