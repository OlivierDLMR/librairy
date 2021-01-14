package Domain;

import Domain.Book.Book;

import javax.persistence.*;
import java.util.List;

@Entity(name = "LIBRARY")
public class Library {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private Type type;

    @Embedded
    private Address address;

    @Embedded
    private Director director;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "LIBRARY_ID", referencedColumnName = "ID")
    private List<Book> books;

    public Library() {}

    public Library(final Long id, final Type type, final Address address, final Director director) {
        this.id = id;
        this.type = type;
        this.address = address;
        this.director = director;
        this.books = books;
    }

    public void update(final Library libraryWithNewInformation) {
        type = libraryWithNewInformation.getType();
        address = libraryWithNewInformation.getAddress();
        director = libraryWithNewInformation.getDirector();
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
