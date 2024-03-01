package k24op1.bookstore.domain;

//import org.hibernate.mapping.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category {
    //Luodaan id, jonka arvo generoidaan automaattisesti
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryid;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @JsonIgnoreProperties("category") //Estetään infinit loop
    private List<Book> books;
public Category(){
   super();
   this.name = null;
}
public Category(String name){
    super();
    this.name = name;
}
//Luodaan id:lle getterit ja setterit
public Integer getCategoryid(){
    return categoryid;
}
public void setCategoryid(Integer categoryid){
    this.categoryid = categoryid;
}
public String getName(){
   return name;
}
public void setName(String name){
    this.name = name;
}
public List<Book> getBooks(){
    return books;
}
public void setBooks(List<Book> books){
    this.books = books;
}
@Override
public String toString(){
    //Tänne ei syötetä lista attribuuttia, muuten tulee infinitive loop
    return "Category [categoryid=" + categoryid + ", name=" + name + "]";
}
}

