package k24op1.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
    //Luodaan id, jonka arvo generoidaan automaattisesti
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private Integer categoryid;
private String name;

public Category(){
   
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
public String getName(String name){
   return name;
}
public void setName(String name){
    this.name = name;
}
@Override
public String toString(){
    return "Category [categoryid=" + categoryid + ", name=" + name + "]";
}
}

