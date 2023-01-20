package az.spring.demo.dto;

import az.spring.demo.entity.Book;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorDto {
    private Long id;
    @NotNull(message = "name shouldn't be null")
    private String name;
    @NotNull(message = "surname shouldn't be null")
    private String surname;
    @Min(14)
    @Max(100)
    private Long age;
    @NotBlank
    private String birthplace;
    List<Book> books = new ArrayList<>();
}