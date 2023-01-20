package az.spring.demo.service.impl;

import az.spring.demo.dto.AuthorDto;
import az.spring.demo.entity.Author;
import az.spring.demo.repository.AuthorRepository;
import az.spring.demo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public void insertAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setAge(authorDto.getAge());
        author.setSurname(authorDto.getSurname());
        author.setBirthplace(authorDto.getBirthplace());
        authorRepository.save(author);
    }
}
