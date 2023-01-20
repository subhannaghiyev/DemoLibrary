package az.spring.demo.service;

import az.spring.demo.dto.LibrarianDto;

import java.util.List;

public interface LibrarianService {
    void insertLibrarian(LibrarianDto librarianDto);

    List<LibrarianDto> getAllLibrarian();
}
