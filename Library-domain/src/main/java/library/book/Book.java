package library.book;

import javax.persistence.*;

public class Book {


    private Long id;


    private String title;


    private String isbn;


    private String author;


    private int numberOfPage;


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



    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }

        if (!this.getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Book that = this.getClass().cast(obj);

        return that.id.equals(id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s{id:%s)", this.getClass().getSimpleName(), id);
    }

    public void assignLiteraryGenre(final LiteraryGenre literaryGenre ) {
        this.literaryGenre = literaryGenre;
    }



}
