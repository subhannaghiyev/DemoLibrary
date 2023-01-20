package az.spring.demo.dto;

import az.spring.demo.entity.Borrower;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @NotNull(message = "name shouldn't be null")
    private String name;
    @NotNull(message = "name shouldn't be null")
    private String surname;
    @Min(15)
    @Max(80)
    private Long age;
    @Email(message = "invalid email address ")
    private String email;
    @Pattern(regexp = "^\\d{10}$",message = "invalid phone number entered")
    private String phone;
    @NotBlank
    private String city;
    List<Borrower> borrowers = new ArrayList<>();
}
