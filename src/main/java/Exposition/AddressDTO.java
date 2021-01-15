package Exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDTO {

    @JsonProperty
    final int number;
    @JsonProperty
    final  String street;
    @JsonProperty
    final  int postalCode;
    @JsonProperty
    final String city;



    public AddressDTO(final int number, final String street, final int postalcCode, final String city) {
        this.number = number;
        this.street = street;
        this.postalCode = postalcCode;
        this.city = city;
    }

}
