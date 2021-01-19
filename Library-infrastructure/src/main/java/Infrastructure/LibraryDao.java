package Infrastructure;

import java.util.List;

import Domain.Library;
import Domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryDao extends JpaRepository<LibraryJPA, Long> {

    List<Library> findByType(Type type);

    List<Library> findByDirector_Surname(String surname);

    //void delete(LibraryJPA libraryJPA);


//    @Query("SELECT library FROM LIBRARY library WHERE library.director.surname = ?1")
//    List<Library> searchByDirectorNameQuery(String surname);
//
//    @Query(value = "SELECT * FROM LIBRARY WHERE DIRECTOR_SURNAME = :surname", nativeQuery = true)
//    List<Library> searchByDirectorNameNativeQuery(String surname);
}