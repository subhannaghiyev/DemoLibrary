package az.spring.demo.service;

import az.spring.demo.dto.BookDto;
import az.spring.demo.exception.UserNotFoundException;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBook();

    List<BookDto> getBookByNames(String name) throws UserNotFoundException;

    void insertBook(BookDto bookDto);

    void deleteBook(Long id);

    void updateBook(BookDto bookDto, Long id);
}
