package br.com.online.complete.school.more.api_restFU_school.domain.directors;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonRequestRegistrationData;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DirectorRequestRegistrationData(
        @NotNull @Valid
        PersonRequestRegistrationData person,
        @NotBlank @Pattern(regexp = "\\(?\\d{2}\\)?\\d{5}\\-?\\d{4}")
        String businessPhone,
        @NotBlank @Pattern(regexp = "\\d{6,9}")
        String professionalRegistration,
        @NotNull
        DirectorPosition position,
        @NotNull   @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate appointmentDate,
        @NotNull    @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate termEndDate
        ) {
}
