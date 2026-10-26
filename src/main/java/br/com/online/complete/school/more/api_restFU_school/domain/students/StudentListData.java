package br.com.online.complete.school.more.api_restFU_school.domain.students;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonListData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record StudentListData(
        PersonListData person,
        String ra,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate
) {
    public StudentListData(StudentEntity entity) {
        this(
                new PersonListData(
                        entity.getId(),
                        entity.getName(),
                        entity.getEmail(),
                        entity.getPhone(),
                        entity.getRg(),
                        entity.getMotherName()
                ),
                entity.getRa(),
                entity.getBirthDate()
        );
    }
}
