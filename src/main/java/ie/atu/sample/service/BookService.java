package ie.atu.sample.service;

import ie.atu.sample.dto.BookDTO;
import ie.atu.sample.model.Author;
import ie.atu.sample.model.Book;
import ie.atu.sample.repository.AuthorRepository;
import ie.atu.sample.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired private BookRepository bookRepository;
    @Autowired private AuthorRepository authorRepository;

    public Book create(BookDTO dto) {
        Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow(() -> new RuntimeException("Author Not Found"+dto.getAuthorId()));
     Book book = new Book();
     book.setTitle(dto.getTitle());
     book.setPrice(dto.getPrice());
     book.setAuthor(author);
     book.setInStock(true);
     return bookRepository.save(book);
    }
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
    public List<Book> getByAuthorName(String name){return bookRepository.findByAuthorName(name);}
    public List<Book> getCheap(Double price){return bookRepository.findCheapInStock(price);}
    public void delete(Long id){bookRepository.deleteById(id);}
}
