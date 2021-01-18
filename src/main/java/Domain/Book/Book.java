package Domain.Book;

import javax.persistence.*;

//@Entity
//@Table(name = "BOOK")
public class Book {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)//génére automatique un ID
    //@Column(name = "ID")// nomme la colonne
    private Long id;

    //@Column(name = "TITLE")
    private String title;

    //@Column(name = "ISBN")
    private String isbn;

    //@Column(name = "AUTHOR")
    private String author;

    //@Column(name = "NUMBER_OF_PAGE")
    private int numberOfPage;

    //@Enumerated(EnumType.STRING)
    //@Column(name = "LITERARY_GENRE")
    private LiteraryGenre literaryGenre;

    private Book() {}

    public Book(final Long id,String title, String isbn, String author, int numberOfPage, LiteraryGenre literaryGenre) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.numberOfPage = numberOfPage;
        this.literaryGenre = literaryGenre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public LiteraryGenre getLiteraryGenre() {
        return literaryGenre;
    }

    public void setLiteraryGenre(LiteraryGenre literaryGenre) {
        this.literaryGenre = literaryGenre;
    }
}
