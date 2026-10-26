package br.com.online.complete.school.more.api_restFU_school.domain.teachers;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonListData;

public record TeacherListData(
        PersonListData person,
        String workPhone,
        Subject subject
) {
    public TeacherListData(TeacherEntity entity) {
        this (
                new PersonListData(
                        entity.getId(),
                        entity.getName(),
                        entity.getEmail(),
                        entity.getPhone(),
                        entity.getRg(),
                        entity.getMotherName()
                ),
                entity.getWorkPhone(),
                entity.getSubject()
        );
    }
}
