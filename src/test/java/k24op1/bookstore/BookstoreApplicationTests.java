package k24op1.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import k24op1.bookstore.web.BookController;
import k24op1.bookstore.web.BooksRestController;
import k24op1.bookstore.web.CategoryController;
import k24op1.bookstore.web.loginController;

@ExtendWith(SpringExtension.class) // JUnit5
@SpringBootTest
class BookstoreApplicationTests {
	// Luodaan auowiret jokaiselle controllerille
	@Autowired
	private BookController bookController;

	@Autowired
	private BooksRestController booksRestController;

	@Autowired
	private CategoryController categoryController;

	@Autowired
	private loginController loginController;

	//Testataan jokainen controller. Metodin nimen täytyy olla eri jokaisessa 
	@Test
	public void contextLoads() {
		assertThat(bookController).isNotNull();
	}
	@Test
	public void testbooksRestController() {
		assertThat(booksRestController).isNotNull();
	}
	@Test
	public void testCategoryController() {
		assertThat(categoryController).isNotNull();
	}
	@Test
	public void testloginController() {
		assertThat(loginController).isNotNull();
	}

}
