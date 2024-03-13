package k24op1.bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import k24op1.bookstore.domain.Book;
import k24op1.bookstore.domain.BookRepository;
import k24op1.bookstore.domain.Category;
import k24op1.bookstore.domain.CategoryRepository;
import k24op1.bookstore.domain.UserRepository;
import k24op1.bookstore.domain.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) //JUnit5
@DataJpaTest

public class UserRepositoryTest {

    @Autowired
    UserRepository urepository;

    @Test // Tarkistetaan, että username user palauttaa oikean sähköpostin. HOX! Ei käsitellä listana
    public void findByName(){
        User user = urepository.findByUsername("user");
        assertThat(user).isNotNull();
        assertThat(user.getEmail()).isEqualTo("u.u@umail.com");
    }
    @Test // testataan save-metodia
    public void createNewUser() {
        User user = new User("tester", "$2a$10$z0/3H.2.KqXRhn8LSrjJYuUa1to6Y0fSYkcQQfbvG/Xf9l0WHnc/C","t.t@tmail.com","TESTER");
        urepository.save(user); // Tallennetaan uusi kategoria
   
       //Haetaan juuri tallennetun kategorian id ja poistetaan kategoria
        Long userId = user.getId();
       urepository.deleteById(userId);
    }
}
