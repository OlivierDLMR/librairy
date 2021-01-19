package Exposition;

import Domain.Type;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

public class LibraryDTO {

    @JsonProperty
    final Type type;

    @JsonProperty
    final AddressDTO addressDTO;

    @JsonProperty
    final DirectorDTO directorDTO;

    @JsonProperty
    final List<BookDTO> bookDTOList;


    public LibraryDTO(Type type, AddressDTO addressDTO, DirectorDTO directorDTO, List<BookDTO> bookDTOList) {
        this.type = type;
        this.addressDTO = addressDTO;
        this.directorDTO = directorDTO;
        this.bookDTOList = Collections.unmodifiableList(bookDTOList);
    }
}
