package ie.atu.sample.repository;

import ie.atu.sample.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long>
{
    @Query("SELECT b FROM Book b WHERE b.author.name = :authorName")
    List<Book> findByAuthorName(@Param("authorName") String authorName);

    @Query("SELECT b FROM Book b WHERE b.price < :price AND b.inStock = true")
    List<Book> findCheapInStock(@Param("price") Double price);
}