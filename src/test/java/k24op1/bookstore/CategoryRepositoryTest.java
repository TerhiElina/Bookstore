package k24op1.bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import k24op1.bookstore.domain.Book;
import k24op1.bookstore.domain.BookRepository;
import k24op1.bookstore.domain.Category;
import k24op1.bookstore.domain.CategoryRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) //JUnit5
@DataJpaTest

public class CategoryRepositoryTest {
    
    @Autowired
    CategoryRepository creporisoty;

    @Test // testataan löytyykö findById:n perusteella oikea kategorian nimi
    public void findById(){
        List <Category> categories = creporisoty.findByCategoryid(1);
        
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Scifi");
    }
    @Test // testataan save-metodia
    public void createNewCategory() {
        Category category = new Category("True crime");
        creporisoty.save(category); // Tallennetaan uusi kategoria
   
       //Haetaan juuri tallennetun kategorian id ja poistetaan kategoria
        Integer categoryid = category.getCategoryid();
       creporisoty.deleteById(categoryid);
    }
    
}