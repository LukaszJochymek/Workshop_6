package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.interf.BookService;
import pl.coderslab.model.Book;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {
    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/all")
    public String showPosts(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "/books/all";

    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
       Book book = new Book();
        model.addAttribute("book", book);
        return "books/form";
    }

    @PostMapping("/add")
    public String save(@Valid Book book,BindingResult result, Model model){
        if(result.hasErrors()) {
            model.addAttribute("books", bookService.getBooks());
            return "books/form";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(Model model,@PathVariable Long id)
    {
        Book book = bookService.get(id).get();
        model.addAttribute("book", book);
        return "books/editForm";
    }
    @PostMapping("/edit")
    public String saveEdit(@Valid Book book,BindingResult result, Model model){
        if(result.hasErrors()) {
            model.addAttribute("books", bookService.getBooks());
            return "books/editForm";
        }
        bookService.update(book);
        return "redirect:/admin/books/all";
    }
    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }
    @GetMapping("/details/{id}")
    public String showDetails(Model model,@PathVariable Long id)
    {
        Book book = bookService.get(id).get();
        model.addAttribute("book", book);
        return "books/details";
    }

}
