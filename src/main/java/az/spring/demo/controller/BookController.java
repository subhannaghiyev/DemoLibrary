package az.spring.demo.controller;

import az.spring.demo.dto.BookDto;
import az.spring.demo.exception.UserNotFoundException;
import az.spring.demo.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookServiceImpl bookService;

    @GetMapping("/getAllBook")
    private List<BookDto> getAll() {
        return bookService.getAllBook();
    }

    @PostMapping("/saveBook")
    private void insertBook(@RequestBody BookDto bookDto) {
        bookService.insertBook(bookDto);
    }

    @GetMapping("/bookName/{name}")
    private List<BookDto> getBooksAll(@PathVariable String name) throws UserNotFoundException {
        name = name == null ? "asasasas" : name;
        return bookService.getBookByNames(name);
    }

    @DeleteMapping("/{id}")
    private void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    private void updateBook(@RequestBody BookDto bookDto, @PathVariable Long id) {
        bookService.updateBook(bookDto, id);
    }
}
