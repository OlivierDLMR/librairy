package Domain.Book;

import Domain.DDD.DDD;

@DDD.Repository
public interface BookRepository {

    Book searchBook(String isbn);
}
