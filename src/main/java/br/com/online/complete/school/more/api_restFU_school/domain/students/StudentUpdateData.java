package br.com.online.complete.school.more.api_restFU_school.domain.students;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonUpdateData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record StudentUpdateData(
        PersonUpdateData person,
        String whatsapp,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate
) {
}
