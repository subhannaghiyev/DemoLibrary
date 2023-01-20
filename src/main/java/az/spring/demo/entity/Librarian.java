package az.spring.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Librarian {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String username;
    private String address;

    @OneToMany(mappedBy = "librarian")
    List<Borrower> borrowerList = new ArrayList<>();
}
