package Domain;

import Domain.DDD.DDD;

import java.util.Objects;

@DDD.ValueObject
public class Address {


    private int number;


    private String street;


    private int postalCode;


    private String city;

    public Address() {}

    public Address(final int number, final String street, final int postalCode, final String city) {
        this.number = number;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }




    @Override
    public boolean equals(final Object obj){
        if(this == obj) {
            return true;
        }
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Address)){
            return false;
        }
        final Address other = (Address) obj;
        return Objects.equals(getNumber(), other.getNumber()) &&
                Objects.equals(getStreet(), other.getStreet())&&
                Objects.equals(getPostalCode(), other.getPostalCode()) &&
                Objects.equals(getCity(), other.getCity());
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(getNumber(), getStreet(), getPostalCode(), getCity());
    }








}
