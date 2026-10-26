package br.com.online.complete.school.more.api_restFU_school.domain.teachers;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonUpdateData;

public record TeacherUpdateData(
        PersonUpdateData person,
        String workPhone,
        Subject subject
) {
}
