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
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    CategoryRepository creporisoty;

    @Test // testataan löytyykö findByAuthorin avulla kirjailijan nimi
    //Repositoryyn täytyy käydä luomassa findByAuthor, jotta testi onnistuu
    public void findByAuthor(){
        List <Book> books = repository.findByAuthor("Aku Ankka");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Akun paketointivinkit");
    }
    @Test // testataan save-metodia
    //Koska category on luotu ainoastaan demo.category luokassa, ei sitä voida suoraan käyttää täällä
    //Categoria on luotava täällä uudestaan.
    public void createNewBook() {
        Category category = new Category("Tietokirja");
        creporisoty.save(category); // Tallennetaan uusi kategoria

        Book book = new Book("Roopen säästövinkit", "Roope Ankka", 2009, "R1234", 25.50, category);
        repository.save(book);

        Integer bookId = book.getId();

        // Tarkistetaan, että kirja löytyy ja sen tiedot ovat oikein. Tämä ohje löytyi chatGpt:stä
        Book foundBook = repository.findById(bookId).orElse(null);
        assertThat(foundBook).isNotNull();
        assertThat(foundBook.getTitle()).isEqualTo("Roopen säästövinkit");
    
        repository.deleteById(bookId); // poistetaan kirja. Ei voi olla erillisessä metodissa, koska muuten ei lue id:tä
    
        // Tarkistetaan, että kirja on poistettu onnistuneesti. Tämä pätkä löytyi chatGptstä
        Book deletedBook = repository.findById(bookId).orElse(null);
        assertThat(deletedBook).isNull();
    }

}
