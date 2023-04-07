package pl.coderslab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 3)
    private String isbn;
    @Size(min = 1)
    private String title;
    @Size(min = 3)
    private String author;
    @Size(min = 3)
    private String publisher;
    @Size(min=1)
    private String type;

//    public Book() {
//    }

//    public Book(Long id, String isbn, String title, String author, String publisher, String type) {
//        this.id = id;
//        this.isbn = isbn;
//        this.title = title;
//        this.author = author;
//        this.publisher = publisher;
//        this.type = type;
//    }


}
