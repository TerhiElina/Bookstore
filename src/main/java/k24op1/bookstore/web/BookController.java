package k24op1.bookstore.web;
import k24op1.bookstore.domain.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class BookController {
    @Autowired
    private BookRepository repository;
    @RequestMapping(value={"/","index"})
    public String bookList(Model model){
        model.addAttribute("books", repository.findAll());
        return "index";
    }
    }
    
    /*public String getBooks (Model model){
        List<Book> books = new ArrayList<Book>();
        model.addAttribute("books", books); 
        return "index";    
    }*/

