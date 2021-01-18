package Domain;


import Domain.exception.ErrorCodes;
import Domain.exception.ValidationException;
import org.springframework.util.StringUtils;

public class Director {


    private String surname;


    private String name;

    public Director (){}

    public Director(final String surname, final String name) {
        this.surname = surname;
        this.name = name;
    }

    public void validate() {
        if (this == null || StringUtils.isEmpty(surname) || StringUtils.isEmpty(name == null)) {
            throw new ValidationException("Director is null", ErrorCodes.LIBRARY_MUST_HAVE_A_DIRECTOR);
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
