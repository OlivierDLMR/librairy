package Exposition;

import Domain.Book.LiteraryGenre;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDTO {

    @JsonProperty
    final String isbn;
    @JsonProperty
    final String title;
    @JsonProperty
    final String author;
    @JsonProperty
    final int  numberOfPage;
    @JsonProperty
    final LiteraryGenre literaryGenre;


    public BookDTO(String isbn, String title, String author, int numberOfPage, LiteraryGenre literaryGenre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.numberOfPage = numberOfPage;
        this.literaryGenre = literaryGenre;
    }
}
