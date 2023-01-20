package az.spring.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class BorrowerDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String issued_by;
    @NotNull
    private LocalDate due_date;
    @NotNull
    private LocalDate return_date;
    private BookDto book;
    private CustomerDto customer;
    private LibrarianDto librarian;
}
