package az.spring.demo.dto;

import az.spring.demo.entity.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class BorrowerDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String issued_by;
    @NotNull
    private LocalDate due_date;
    @NotNull
    private LocalDate return_date;
    private Long book;
    private CustomerDto customer;
    private LibrarianDto librarian;
}
