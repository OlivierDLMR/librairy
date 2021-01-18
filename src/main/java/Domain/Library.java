package Domain;

import Domain.Book.Book;
import Domain.DDD.DDD;


import java.util.List;
import java.util.Objects;

@DDD.Entity
public class Library {

    private Long id;


    private Type type;


    private Address address;


    private Director director;


    private List<Book> books;

    public Library() {}

    public Library(final Long id, final Type type, final Address address, final Director director, List<Book> books) {
        this.id = id;
        this.type = type;
        this.address = address;
        this.director = director;
        this.books = books;
        validate();
    }



    public void update(final Library libraryWithNewInformation) {
        type = libraryWithNewInformation.getType();
        address = libraryWithNewInformation.getAddress();
        director = libraryWithNewInformation.getDirector();
        validate();
    }

    private void validate() {
        director.validate();
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


    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Library)) {
            return false;
        }
        final Library other = (Library) obj;
        return Objects.equals(getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return String.format("%s{id:%s)", this.getClass().getSimpleName(), id);
    }

}
