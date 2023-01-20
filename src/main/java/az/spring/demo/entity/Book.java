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
    @GeneratedValue
    private Long id;
    private Long isbn;
    private String title;
    private String name;
    private Double price;
    private String description;
    private Boolean available;
    @OneToMany(mappedBy = "book")
    List<Borrower> borrowers = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
