package az.spring.demo.service.impl;

import az.spring.demo.dto.LibrarianDto;
import az.spring.demo.entity.Librarian;
import az.spring.demo.repository.LibrarianRepository;
import az.spring.demo.service.LibrarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibrarianServiceImpl implements LibrarianService {
    private final LibrarianRepository librarianRepository;

    @Override
    public void insertLibrarian(LibrarianDto librarianDto) {
        Librarian librarian = new Librarian();
        librarian.setName(librarianDto.getName());
        librarian.setUsername(librarianDto.getUsername());
        librarian.setAddress(librarianDto.getAddress());
        librarian.setEmail(librarianDto.getEmail());
        librarianRepository.save(librarian);
    }


    @Override
    public List<LibrarianDto> getAllLibrarian() {
        return librarianRepository.findAll()
                .stream()
                .map(this::convertToDtoLibrarian)
                .collect(Collectors.toList());
    }


    private LibrarianDto convertToDtoLibrarian(Librarian librarian) {
        LibrarianDto librarianDto = new LibrarianDto();
        librarianDto.setId(librarian.getId());
        librarianDto.setName(librarian.getName());
        librarianDto.setAddress(librarian.getAddress());
        librarianDto.setUsername(librarian.getUsername());
        librarianDto.setEmail(librarian.getEmail());
        return librarianDto;
    }
}
