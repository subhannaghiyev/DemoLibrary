package az.spring.demo.dto;

import az.spring.demo.entity.Author;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class BookDto {
    private Long id;
    @NotNull
    private Long isbn;
    @NotNull
    private String title;
    @NotNull
    private String name;
    @NotNull
    private Double price;
    @NotBlank
    private String description;
    private Boolean available;
    List<BorrowerDto> borrowers = new ArrayList<>();
    private Author author;
}
