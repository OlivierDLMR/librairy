package Infrastructure;

import Domain.Library;
import Domain.LibraryRepository;
import Domain.Type;
import Domain.exception.ErrorCodes;
import Domain.exception.LibraryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class LibraryRepositoryImpl implements LibraryRepository {

    @Autowired
    private LibraryDao libraryDAO;


    @Override
    public List<Library> findAllType(Type type) {
        return libraryDAO.findByType(type).stream().map(LibraryJPA::toLibrary).collect(Collectors.toList());
    }
    @Override
    public List<Library> findAllByDirector(String name) {
        return libraryDAO.findByDirector_Surname(surname).stream().map(LibraryJPA::toLibrary).collect(Collectors.toList());
    }


    @Override
    public Long save(final Library library) {
        final LibraryJPA libraryJPA = libraryDAO.save(new LibraryJPA(library));
        return libraryJPA.getId();
    }

    @Override
    public List<Library> findAll() {
        return libraryDAO.findAll().stream().map(LibraryJPA::toLibrary).collect(Collectors.toList());
    }

    @Override
    public void delete(final Library library) {
        libraryDAO.delete(new LibraryJPA(library));
    }

    @Override
    public List<Library> findLibraryByType(final Type type) {
        return libraryDAO.findByType(type);
    }

    @Override
    public List<Library> findLibraryByDirectorSurname(final String surname) {
        return libraryDAO.findByDirector_Surname(surname);
    }

}
