package k24op1.bookstore.web;
import k24op1.bookstore.domain.BookRepository;
import k24op1.bookstore.domain.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import k24op1.bookstore.domain.Book;




@Controller

public class BookController {
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value={"/booklist"})
    public String bookList(Model model){
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    @RequestMapping(value = "/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("category", categoryRepository.findAll());
        return "addbook";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Integer bookId, Model model){
        Book book = repository.findById(bookId).orElse(null);
        if (book == null) {
            //This handles, if the book is null
            return "redirect:/booklist";
        }
        model.addAttribute("book", book);
        return "editbook";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
        @PreAuthorize("hasRole('ADMIN')")
        public String deleteBook(@PathVariable("id") Integer bookId, Model model){
         repository.deleteById(bookId);
         return "redirect:../booklist";   
        }


    }
    


