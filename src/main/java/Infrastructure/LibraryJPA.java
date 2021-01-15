package Infrastructure;

import Domain.Address;
import Domain.Book.Book;
import Domain.Director;
import Domain.Library;
import Domain.Type;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

    @Entity
    @Table(name = "LIBRARY")
    public class LibraryJPA {

        @Id
        @GeneratedValue
        @Column(name = "ID")
        private Long id;

        @Enumerated(EnumType.STRING)
        @Column(name = "TYPE")
        private Type type;

        @Column(name = "ADDRESS_NUMBER")
        private int addressNumber;

        @Column(name = "ADDRESS_STREET")
        private String addressStreet;

        @Column(name = "ADDRESS_POSTALCODE")
        private int addressPostalCode;

        @Column(name = "ADDRESS_CITY")
        private String addressCity;

        @Column(name = "DIRECTOR_SURNAME")
        private String directorSurname;

        @Column(name = "DIRECTOR_NAME")
        private String directorName;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name="LIBRARY_ID", referencedColumnName = "ID")
        private List<BokkJPA.BookJPA> books;

        private LibraryJPA() {}

        public LibraryJPA(final Library library) {
            id = library.getId();
            type = library.getType();
            addressNumber = library.getAddress().getNumber();
            addressStreet = library.getAddress().getStreet();
            addressPostalCode = library.getAddress().getPostalCode();
            addressCity = library.getAddress().getCity();
            directorSurname = library.getDirector().getSurname();
            directorName = library.getDirector().getName();
            books = library.getBooks().stream().map(BokkJPA.BookJPA::new).collect(Collectors.toList());
        }

        public Library toLibrary() {
            final Address address = new Address(addressNumber, addressStreet, addressPostalCode, addressCity);

            final Director director = new Director(directorSurname, directorName);

            final List<Book> bookList = books.stream().map(b -> new Book(b.getId(), b.getIsbn(), b.getTitle(), b.getAuthor(), b.getNumberOfPage(), b.getLiteraryGenre())).collect(Collectors.toList());

            return new Library(id, type, address, director, bookList);
        }

        public Long getId() {
            return id;
        }

        public Type getType() {
            return type;
        }

        public int getAddressNumber() {
            return addressNumber;
        }

        public String getAddressStreet() {
            return addressStreet;
        }

        public int getAddressPostalCode() {
            return addressPostalCode;
        }

        public String getAddressCity() {
            return addressCity;
        }

        public String getDirectorSurname() {
            return directorSurname;
        }

        public String getDirectorName() {
            return directorName;
        }

        public List<BokkJPA.BookJPA> getBooks() {
            return books;
        }
    }

