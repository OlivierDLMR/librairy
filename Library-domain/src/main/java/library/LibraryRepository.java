package library;

import Domain.DDD.DDD;

import java.util.List;

@DDD.Repository
public interface LibraryRepository {

    Long save(Library library);

    Library get(Long id);

    List<Library> findAll();

    void delete(Library library);

    List<Library> findLibraryByType(Type type);

    List<Library> findLibraryByDirectorSurname(String surname);

}
