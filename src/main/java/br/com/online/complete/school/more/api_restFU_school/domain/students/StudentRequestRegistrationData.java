package br.com.online.complete.school.more.api_restFU_school.domain.students;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonRequestRegistrationData;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record StudentRequestRegistrationData(
        @NotNull   @Valid
        PersonRequestRegistrationData person,
        @NotBlank   @Pattern(regexp = "\\(?\\d{2}\\)?\\d{5}\\-?\\d{4}")
        String whatsapp,
        @NotBlank    @Pattern(regexp = "\\d{4,6}")
        String ra,
        @NotNull(message = "The birth date is required")    @Past(message = "The birth date must be in the past")  @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate
) {
}
