package az.spring.demo.controller;

import az.spring.demo.dto.LibrarianDto;
import az.spring.demo.service.LibrarianService;
import az.spring.demo.service.impl.LibrarianServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/librarians")
public class LibrarianController {

    private final LibrarianServiceImpl librarianService;

    @PostMapping("/saveLibrarian")
    private void insertLibrarian(@RequestBody LibrarianDto librarianDto) {
        librarianService.insertLibrarian(librarianDto);
    }

    @GetMapping("showAllLibrarians")
    private List<LibrarianDto> getAllLibrarian() {
        return librarianService.getAllLibrarian();
    }
}
