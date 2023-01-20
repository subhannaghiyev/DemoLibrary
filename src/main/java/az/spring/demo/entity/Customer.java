package az.spring.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Long age;
    private String email;
    private String phone;
    private String city;
    @OneToMany(mappedBy = "customer")
    private List<Borrower> borrowers = new ArrayList<>();
}
