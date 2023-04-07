package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.interf.BookService;
import pl.coderslab.service.JpaBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final JpaBookService jpaBookService;
@Autowired
    public BookController(BookService bookService, JpaBookService jpaBookService) {
        this.bookService = bookService;
    this.jpaBookService = jpaBookService;
}

//    @RequestMapping("/helloBook")
//    public Book helloBook() {
//        return new Book(1L, "9788324631766", "Thinking in Java",
//                "Bruce Eckel", "Helion", "programming");
//
//    }
    @GetMapping("")
    @ResponseBody
    public List<Book> getList() {
        return jpaBookService.getBooks();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return this.bookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }
    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        bookService.delete(id);
    }
    @PutMapping("")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }
}