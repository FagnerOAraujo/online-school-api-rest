package br.com.online.complete.school.more.api_restFU_school.domain.students;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonResponseData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record StudentResponseData(
        PersonResponseData person,
        String whatsapp,
        String ra,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate
) {
    public StudentResponseData(StudentEntity entity) {
        this(
                new PersonResponseData(
                        entity.getId(),
                        entity.getName(),
                        entity.getEmail(),
                        entity.getPhone(),
                        entity.getMobilePhone(),
                        entity.getRegistration(),
                        entity.getRg(),
                        entity.getCpf(),
                        entity.getMotherName(),
                        entity.getAddress()
                ),
                entity.getWhatsapp(),
                entity.getRa(),
                entity.getBirthDate()
        );
    }
}
