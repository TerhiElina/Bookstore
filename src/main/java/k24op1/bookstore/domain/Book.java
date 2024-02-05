package k24op1.bookstore.domain;
//Attribuutit

public class Book {
private String title;
private String author;
private Integer publicationYear;
private String isbn;
private Double price;

//Konstruktorit
public Book(){
    super();
    this.title = null;
    this.author = null;
    this.publicationYear = 0;
    this.isbn = null;
    this.price = 0.00;
}
public Book (String title, String author, Integer publicationYear, String isbn, Double price ){
    super();
    this.title = title;
    this.author = author;
    this.publicationYear = publicationYear;
    this.isbn = isbn;
    this.price = price;
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
// Getterit
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
@Override
public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
}
}