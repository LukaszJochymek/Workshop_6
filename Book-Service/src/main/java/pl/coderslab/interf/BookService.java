package pl.coderslab.interf;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    List<Book> getBooks();
    void add(Book book);
    Optional<Book> get(Long id);
    void delete(Long id);
    void update(Book book);
}

