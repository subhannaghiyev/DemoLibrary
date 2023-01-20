package az.spring.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long isbn;
    private String title;
    private String name;
    private Double price;
    private String description;
    private Boolean available;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Borrower> borrowers = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
