package k24op1.bookstore.web;
import java.util.List;
import java.util.ArrayList;
import k24op1.bookstore.domain.Book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BookController {
    @RequestMapping("/welcome")
public String Welcome() {
return "index";
}

    @GetMapping("/index")
    public String getBooks (Model model){
        List<Book> books = new ArrayList<Book>();
        model.addAttribute("books", books); 
        return "index";    
    }
}
