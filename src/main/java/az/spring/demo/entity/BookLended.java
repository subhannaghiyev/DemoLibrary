package az.spring.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class BookLended {
    @Id
    private Long id;
    private Long isbn;
    private String title;
    private LocalDate issuedate;
    private String address;

}
