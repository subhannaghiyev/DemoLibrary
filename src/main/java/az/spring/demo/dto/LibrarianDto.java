package az.spring.demo.dto;

import az.spring.demo.entity.Borrower;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class LibrarianDto {
    private Long id;
    @NotNull
    private String name;
    @Email
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    private String address;
    List<Borrower> borrowerList = new ArrayList<>();
}
