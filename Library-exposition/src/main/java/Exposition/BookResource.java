package Exposition;

import Application.BookService;
import Domain.Book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookResource {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO searchBookByISBN(@RequestParam("isbn") final String isbn) {
        final Book book = bookService.searchBookByISBN(isbn);
        return new BookDTO(isbn, book.getTitle(), book.getAuthor(), book.getNumberOfPage(), book.getLiteraryGenre());
    }
}