package k24op1.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Attribuutit
@Entity // Merkitään tietokannan tauluksi
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String isbn;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

//Konstruktorit
public Book(){
    super();
    this.title = null;
    this.author = null;
    this.publicationYear = 0;
    this.isbn = null;
    this.price = 0.00;
    this.category = null;
}
public Book (String title, String author, Integer publicationYear, String isbn, Double price, Category category ){
    super();
    this.title = title;
    this.author = author;
    this.publicationYear = publicationYear;
    this.isbn = isbn;
    this.price = price;
    this.category = category;
}
// setterit
public void setTitle(String title){
    this.title = title;
}
public void setAuthor(String author) {
    this.author = author;
}
public void setPublicationYear(Integer publicationYear){
    this.publicationYear = publicationYear;
}
public void setIsbn (String isbn){
    this.isbn = isbn;
}
public void setPrice (Double price){
    this.price = price;
}
public void setCategory (Category category){
    this.category = category;
}
// Getterit
public Integer getId() {
    return id;
}
public String getTitle(){
    return title;
}
public String getAuthor(){
    return author;
}
public Integer getPublicationYear(){
    return publicationYear;
}
public String getIsbn(){
    return isbn;
}
public Double getPrice(){
    return price;
}
public Category getCategory(){
    return category;
}
@Override
public String toString() {
    if (this.category != null)
        return "Book [title]" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn + ", price=" + price + " category=" + this.getCategory() +"]";
    else
        return "Book [title]" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn + ", price=" + price + "]";
}
}
