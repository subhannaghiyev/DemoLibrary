package az.spring.demo.service;

import az.spring.demo.dto.BorrowerDto;

import java.util.List;

public interface BorrowerService {

    void insertBorrower(BorrowerDto borrowerDto);


    List<BorrowerDto> getAllBorrowers();
}
