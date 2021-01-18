package Application;

import Domain.Book.Book;
import Domain.Book.BookRepository;
import Domain.DDD.DDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DDD.ApplicationService
@Transactional
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book searchBookByISBN(final String isbn) {
        return bookRepository.searchBook(isbn);
    }


}