package k24op1.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k24op1.bookstore.domain.Book;
import k24op1.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository){
		return (args) ->{
			Book book1 = new Book("Mikki Merihädässä", "Mikki Hiiri", 2001, "M1234", 20.50 );
			Book book2 = new Book("Akun paketointivinkit", "Aku Ankka", 2009, "A1234", 25.50 );

			//Saving the testdata to the repository
			bookRepository.save(book1);
			bookRepository.save(book2);
		};
	}
}
