package Exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DirectorDTO {

    @JsonProperty
    final String surname;
    @JsonProperty
    final String name;


    public DirectorDTO(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }
}
