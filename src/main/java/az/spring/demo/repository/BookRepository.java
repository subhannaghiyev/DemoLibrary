package az.spring.demo.repository;

import az.spring.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("Select c from Book c where c.name LIKE  %?1%")
    List<Book> findPlaceContainingKeywordAnywhere(String name);

}
