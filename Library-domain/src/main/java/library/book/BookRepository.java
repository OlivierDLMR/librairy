package library.book;

import Domain.DDD.DDD;

@DDD.Repository
public interface BookRepository {

    Book searchBook(String isbn);
}
