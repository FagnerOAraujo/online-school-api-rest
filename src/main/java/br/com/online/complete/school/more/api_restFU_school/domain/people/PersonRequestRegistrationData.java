package br.com.online.complete.school.more.api_restFU_school.domain.people;

import br.com.online.complete.school.more.api_restFU_school.domain.address.AddressRequestData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record PersonRequestRegistrationData(
        @NotBlank
        String name,
        @NotBlank @Email
        String email,
        @NotBlank @Pattern(regexp = "\\(?\\d{2}\\)?\\d{4}\\-?\\d{4}")
        String phone,
        @NotBlank @Pattern(regexp = "\\(?\\d{2}\\)?\\d{5}\\-?\\d{4}")
        String mobilePhone,
        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String registration,
        @NotBlank @Pattern(regexp = "\\d{2}\\.?\\d{3}\\.?\\d{3}\\-?\\d{1}")
        String rg,
        @NotBlank @CPF
        String cpf,
        @NotBlank
        String motherName,
        @NotNull  @Valid
        AddressRequestData address
        ) {
}
