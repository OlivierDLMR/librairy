package Exposition;

import Domain.Address;
import Domain.Book.Book;
import Domain.Director;
import Domain.Library;

import java.util.List;
import java.util.stream.Collectors;

public final class LibraryAdapter {

    private LibraryAdapter() {
    }

    public static Library transformToLibrary(final LibraryDTO libraryDTO) {
        final Address address = new Address(libraryDTO.addressDTO.number, libraryDTO.addressDTO.street,
                libraryDTO.addressDTO.postalCode, libraryDTO.addressDTO.city);

        final Director director = new Director(libraryDTO.directorDTO.surname, libraryDTO.directorDTO.name);

        return new Library(libraryDTO.type, address, director, transformToBook(libraryDTO.bookDTOList));
    }

    public static List<Book> transformToBook(final List<LibraryDTO.BookDTO> bookDTO) {
        return bookDTO.stream().map(b -> new Book(b.isbn, b.title, b.author, b.numberOfPage, b.literaryGenre))
                .collect(Collectors.toList());
    }

    public static LibraryDTO adaptToBookDTO(final Library library) {
        return new LibraryDTO(library.getType(),
                new LibraryDTO.AddressDTO(library.getAddress().getNumber(), library.getAddress().getStreet(),
                        library.getAddress().getPostalCode(), library.getAddress().getCity()),
                new LibraryDTO.DirectorDTO(library.getDirector().getSurname(), library.getDirector().getName()),
                LibraryAdapter.adaptToBookListDTO(library.getBooks()));
    }

    public static List<LibraryDTO> adaptToLibraryDTO(final List<Library> libraries) {
        return libraries.stream().map(LibraryAdapter::adaptToBookDTO).collect(Collectors.toList());
    }

    public static List<LibraryDTO.BookDTO> adaptToBookListDTO(final List<Book> books) {
        return books.stream().map(LibraryAdapter::adaptToBookDTO).collect(Collectors.toList());
    }

    public static LibraryDTO.BookDTO adaptToBookDTO(final Book book) {
        return new LibraryDTO.BookDTO(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getNumberOfPage(),
                book.getLiteraryGenre());
    }

}