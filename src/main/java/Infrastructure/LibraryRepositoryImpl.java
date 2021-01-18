package Infrastructure;

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

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {

    @Autowired
    private LibraryDao libraryDAO;

    @Override
    public Long save(final Library library) {
        final LibraryJPA libraryJPA = libraryDAO.save(new LibraryJPA(library));
        return libraryJPA.getId();
    }

    @Override
    public Library get(final Long id) {
        return libraryDAO.findById(id).map(LibraryJPA::toLibrary).orElseThrow(
                () -> new NotFoundException("Could not obtain library " + id, ErrorCodes.LIBRARY_NOT_FOUND));
    }

    @Override
    public List<Library> findAll() {
        final List<LibraryJPA> libraryJPAs = libraryDAO.findAll();
        final List<Library> result = new ArrayList<Library>();
        for (final LibraryJPA libraryJPA : libraryJPAs) {
            result.add(libraryJPA.toLibrary());
        }
        return result;
    }

    @Override
    public void delete(final Library library) {
        libraryDAO.delete(new LibraryJPA(library));
    }

    @Override
    public List<Library> findLibraryByType(Type type) {
        return libraryDAO.findByType(type);
    }

    @Override
    public List<Library> findLibraryByDirectorSurname(String surname) {
        return libraryDAO.findByDirector_Surname(surname);
    }



}