package k24op1.bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demoCategory(BookRepository bookRepository, CategoryRepository categoryRepository){
	
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

			bookRepository.save(new Book("Mikki Merihädässä", "Mikki Hiiri", 2001, "M1234", 20.50, category1));
			bookRepository.save(new Book("Akun paketointivinkit", "Aku Ankka", 2009, "A1234", 25.50, category2 ));

			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
	


