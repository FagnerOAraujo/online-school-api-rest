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

    public void updateData(AddressRequestData address) {
        if (address.street() != null) {
            this.street = address.street();
        }
        if (address.neighborhood() != null) {
            this.neighborhood = address.neighborhood();
        }
        if (address.city() != null) {
            this.city = address.city();
        }
        if (address.state() != null) {
            this.state = address.state();
        }
        if (address.country() != null) {
            this.country = address.country();
        }
        if (address.postalCode() != null) {
            this.postalCode = address.postalCode();
        }
        if (address.number() != null) {
            this.number = address.number();
        }
        if (address.complement() != null) {
            this.complement = address.complement();
        }
    }
}
