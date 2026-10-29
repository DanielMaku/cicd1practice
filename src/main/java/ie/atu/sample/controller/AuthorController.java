package ie.atu.sample.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ie.atu.sample.model.Author;
import ie.atu.sample.repository.AuthorRepository;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepo;

    @PostMapping
    public ResponseEntity<Author> create(@RequestBody Author author) {
        return new ResponseEntity<>(authorRepo.save(author), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Author> getAll() {
        return authorRepo.findAll();
    }
}