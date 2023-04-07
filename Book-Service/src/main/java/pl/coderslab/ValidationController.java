package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.model.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")

    public String checkBook(Model model) {
        Book book = new Book();

        Set<ConstraintViolation<Book>> constraintViolationsBook = validator.validate(book);

        if (constraintViolationsBook.isEmpty()) {
            return "ok";
        } else {
            model.addAttribute("validationsBook", constraintViolationsBook);

        }

        return "validate/validate";

    }
}
