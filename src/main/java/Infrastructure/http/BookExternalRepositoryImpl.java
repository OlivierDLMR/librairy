package Infrastructure.http;

import Domain.Book.Book;
import Domain.Book.BookRepository;
import Domain.DDD.DDD;
import Domain.exception.ErrorCodes;
import Domain.exception.OpenLibraryTechnicalException;
import Infrastructure.http.dto.AuthorInfo;
import Infrastructure.http.dto.BookInfo;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@DDD.RepositoryImpl
@Component
public class BookExternalRepositoryImpl implements BookRepository {

    private static final Logger logger = LoggerFactory.getLogger(BookExternalRepositoryImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Book searchBook(final String isbn ) {

        try {
            final ResponseEntity<BookInfo> response = restTemplate.getForEntity("/isbn/" + isbn + ".json",
                    BookInfo.class);

            final BookInfo bookInfo = response.getBody();
            logger.debug(bookInfo.toString());

            final String authorName = searchAuthor(bookInfo.getAuthors().get(0).getKey());

            return new Book(null, isbn, bookInfo.getTitle(), authorName, bookInfo.getNumber_of_pages(), null);

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            if (HttpStatus.NOT_FOUND.equals(e.getStatusCode())) {
                throw new NotFoundException("Book # " + isbn + "Not found", ErrorCodes.BOOK_NOT_FOUND);
            }
            throw new OpenLibraryTechnicalException(e);
        }
    }

    private String searchAuthor(final String key) {
        String authorName = "unkwnown";

        if (!key.isEmpty()) {
            try {
                final ResponseEntity<AuthorInfo> response = restTemplate.getForEntity(key + ".json", AuthorInfo.class);
                final AuthorInfo authorInfo = response.getBody();
                authorName = authorInfo.getName();

            } catch (final RestClientException e) {
                logger.error("Error on author call for " + key);
            }
        }
        return authorName;
    }

}