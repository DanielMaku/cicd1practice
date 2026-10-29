package ie.atu.sample.controller;

import ie.atu.sample.dto.BookDTO;
import ie.atu.sample.model.Book;
import ie.atu.sample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody BookDTO dto) {
        return new ResponseEntity<>(bookService.create(dto), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Book> getAll() { return bookService.getAll(); }
    @GetMapping("/author/{authorName}")
    public List<Book> getByAuthor(@PathVariable String authorName) { return bookService.getByAuthorName(authorName); }
    @GetMapping("/cheap")
    public List<Book> getCheap(@RequestParam Double price) { return bookService.getCheap(price); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { bookService.delete(id); return ResponseEntity.noContent().build(); }
}