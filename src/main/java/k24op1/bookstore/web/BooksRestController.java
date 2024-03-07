package k24op1.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import k24op1.bookstore.domain.Book;

import k24op1.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BooksRestController {
    @Autowired
    private BookRepository repository;

@GetMapping("/books")
public @ResponseBody List <Book> getBookRest()   {
    return (List <Book>) repository.findAll();
}
//Haetaan yhden kirjan tietoja käyttämällä path variablea
@GetMapping ("/books/{id}")
public @ResponseBody Optional <Book> getBookById(@PathVariable("id") Integer BookId){
return repository.findById(BookId);
}

@PostMapping("/books")
public @ResponseBody Book addBook(@RequestBody Book newBook){
   return repository.save(newBook); 
}



}
