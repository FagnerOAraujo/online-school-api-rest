package br.com.online.complete.school.more.api_restFU_school.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressRequestData(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        String country,
        @NotBlank   @Pattern(regexp = "\\d{5}\\-?\\d{3}")
        String postalCode,
        @NotBlank
        String number,
        @NotBlank
        String complement

) {
}
