package br.com.online.complete.school.more.api_restFU_school.domain.teachers;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonResponseData;

public record TeacherResponseData(
        PersonResponseData person,
        String workPhone,
        String enrollment,
        Subject subject
) {
    public TeacherResponseData(TeacherEntity entity) {
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
                entity.getWorkPhone(),
                entity.getEnrollment(),
                entity.getSubject()
        );
    }
}
