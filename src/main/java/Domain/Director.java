package Domain;


import Domain.DDD.DDD;
import Domain.exception.ErrorCodes;
import Domain.exception.ValidationException;
import org.springframework.util.StringUtils;

import java.util.Objects;

@DDD.ValueObject
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


    @Override
    public boolean equals(final Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Director)){
            return false;
        }
        final Director other = (Director) obj;
        return Objects.equal(getName(), other.getName()) && //
                Objects.equal(getSurname(), other.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName(), getSurname());
    }










}
