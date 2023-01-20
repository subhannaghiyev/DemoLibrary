package az.spring.demo.service.impl;

import az.spring.demo.dto.BookDto;
import az.spring.demo.entity.Book;
import az.spring.demo.exception.UserNotFoundException;
import az.spring.demo.repository.BookRepository;
import az.spring.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<BookDto> getAllBook() {
        return bookRepository.findAll()
                .stream()
                .map(this::convertToDtoBook)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> getBookByNames(String name) throws UserNotFoundException {
        List<Book> bookName = bookRepository.findPlaceContainingKeywordAnywhere(name);
        if (bookName.isEmpty()) {
            throw new UserNotFoundException("there is no book that starts with that name : " + name);
        }
        return bookName.stream().map(this::convertToDtoBook)
                .collect(Collectors.toList());
    }

    @Override
    public void insertBook(BookDto bookDto) {
        Book book = new Book();
        book.setIsbn(bookDto.getIsbn());
        book.setName(bookDto.getName());
        book.setPrice(bookDto.getPrice());
        book.setAvailable(bookDto.getAvailable());
        book.setTitle(bookDto.getTitle());
        book.setDescription(book.getDescription());
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void updateBook(BookDto bookDto, Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setIsbn(bookDto.getIsbn());
        book.setName(bookDto.getName());
        book.setDescription(bookDto.getDescription());
        book.setAvailable(bookDto.getAvailable());
        book.setPrice(bookDto.getPrice());
        book.setTitle(bookDto.getTitle());
        bookRepository.save(book);

    }

    private BookDto convertToDtoBook(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setName(book.getName());
        bookDto.setTitle(book.getTitle());
        bookDto.setPrice(book.getPrice());
        bookDto.setAvailable(book.getAvailable());
        bookDto.setDescription(book.getDescription());

        return bookDto;
    }

}
