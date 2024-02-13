package k24op1.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import k24op1.bookstore.domain.Category;
import k24op1.bookstore.domain.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class CategoryController {
 @Autowired
    private CategoryRepository repository;

    @RequestMapping(value={"/categorylist"})
    public String CategoryList(Model model){
        model.addAttribute("categories", repository.findAll());
        return "categorylist";
    }
    @GetMapping("/addcategory")
    public String addCategory (Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }
    @RequestMapping(value= "/savecategory", method = RequestMethod.POST)
    public String save(Category category) {
        repository.save(category);
        return "redirect:categorylist";
    }
    
    

}
