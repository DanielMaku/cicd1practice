package ie.atu.sample.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private double price;
    private Boolean inStock = true;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    public Book() {}
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public Boolean getInStock() {return inStock;}
    public void setInStock(Boolean inStock) {this.inStock = inStock;}
    public Author getAuthor() {return author;}
    public void setAuthor(Author author) {this.author = author;}

}
