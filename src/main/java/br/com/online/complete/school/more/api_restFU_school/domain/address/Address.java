package br.com.online.complete.school.more.api_restFU_school.domain.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    @Column(name = "postalCode")
    private String postalCode;
    private String number;
    private String complement;

    public Address(@NotNull @Valid AddressRequestData address) {
        this.street = address.street();
        this.neighborhood = address.neighborhood();
        this.city = address.city();
        this.state = address.state();
        this.country = address.country();
        this.postalCode = address.postalCode();
        this.number = address.number();
        this.complement = address.complement();
    }
}
