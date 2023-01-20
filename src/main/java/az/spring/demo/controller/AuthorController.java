package az.spring.demo.controller;

import az.spring.demo.dto.AuthorDto;
import az.spring.demo.service.impl.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorServiceImpl authorService;

    @PostMapping("/saveAuthor")
    private void insertAuthor(@RequestBody AuthorDto authorDto) {
        authorService.insertAuthor(authorDto);
    }
}
