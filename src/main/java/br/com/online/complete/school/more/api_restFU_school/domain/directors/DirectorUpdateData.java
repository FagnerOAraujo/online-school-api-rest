package br.com.online.complete.school.more.api_restFU_school.domain.directors;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonUpdateData;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DirectorUpdateData(
        PersonUpdateData person,
        String businessPhone,
        @Pattern(regexp = "\\d{6,9}")
        String professionalRegistration,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate appointmentDate,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate termEndDate
) {
}
