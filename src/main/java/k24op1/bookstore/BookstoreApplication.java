package k24op1.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k24op1.bookstore.domain.Book;
import k24op1.bookstore.domain.BookRepository;
import k24op1.bookstore.domain.Category;
import k24op1.bookstore.domain.CategoryRepository;

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
	@Bean
	public CommandLineRunner demoCategory(CategoryRepository categoryRepository){
		return (args) ->{
			Category category1 = new Category("Scifi" );
			Category category2 = new Category("fantasy" );
			Category category3 = new Category("Horror" );

			//Saving the testdata to the repository
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

			//The following is logging the data,so I can see it in Terminal
			System.out.println("Categories inserted:");
        	System.out.println(category1);
        	System.out.println(category2);
        	System.out.println(category3);
		};
	}
}
