package az.spring.demo.service.impl;

import az.spring.demo.dto.BookDto;
import az.spring.demo.dto.BorrowerDto;
import az.spring.demo.entity.Book;
import az.spring.demo.entity.Borrower;
import az.spring.demo.repository.BorrowerRepository;
import az.spring.demo.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {
    private final BorrowerRepository borrowerRepository;

    @Override
    public void insertBorrower(BorrowerDto borrowerDto) {
        Borrower borrowerr = new Borrower();
        borrowerr.setName(borrowerDto.getName());
        borrowerr.setIssued_by(borrowerDto.getIssued_by());
        borrowerr.setDue_date(borrowerDto.getDue_date());
        borrowerr.setReturn_date(borrowerDto.getReturn_date());


        borrowerRepository.save(borrowerr);
    }


    @Override
    public List<BorrowerDto> getAllBorrowers() {
        return borrowerRepository.findAll()
                .stream()
                .map(this::convertToDoDtoBorrower)
                .collect(Collectors.toList());
    }

    private BorrowerDto convertToDoDtoBorrower(Borrower borrower) {
        BorrowerDto borrowerDto = new BorrowerDto();
        borrowerDto.setId(borrower.getId());
        borrowerDto.setName(borrower.getName());
        borrowerDto.setIssued_by(borrower.getIssued_by());
        borrowerDto.setDue_date(borrower.getDue_date());
        borrowerDto.setReturn_date(borrower.getReturn_date());


        return borrowerDto;
    }
}
