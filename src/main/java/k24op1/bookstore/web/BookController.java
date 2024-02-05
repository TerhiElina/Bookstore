package k24op1.bookstore.web;
import k24op1.bookstore.domain.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.ArrayList;



@Controller

public class BookController {
    @Autowired
    private BookRepository repository;
    @RequestMapping(value={"/booklist"})
    public String bookList(Model model){
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
    }
    
    /*public String getBooks (Model model){
        List<Book> books = new ArrayList<Book>();
        model.addAttribute("books", books); 
        return "index";    
    }*/

