package Infrastructure;

import Domain.DDD.DDD;
import Domain.Library;
import Domain.LibraryRepository;
import Domain.Type;
import Domain.exception.ErrorCodes;
import Domain.exception.LibraryNotFoundException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DDD.RepositoryImpl
@DDD.Repository
public class LibraryRepositoryImpl implements LibraryRepository {

    @Autowired
    private LibraryDao libraryDAO;

    @Override
    public Library get(final Long id) {
        return libraryDAO.findById(id).map(LibraryJPA::toLibrary).orElseThrow(
                () -> new NotFoundException("Could not obtain library " + id, ErrorCodes.LIBRARY_NOT_FOUND));
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