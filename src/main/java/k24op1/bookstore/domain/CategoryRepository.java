package k24op1.bookstore.domain;

import org.springframework.data.repository.CrudRepository;
//Luodaan crudRepository, jonka avulla voidaan käyttää crud toimintoja
public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
