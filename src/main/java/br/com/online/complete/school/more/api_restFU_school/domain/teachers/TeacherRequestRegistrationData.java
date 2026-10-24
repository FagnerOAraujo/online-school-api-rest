package br.com.online.complete.school.more.api_restFU_school.domain.teachers;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonRequestRegistrationData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record TeacherRequestRegistrationData(
        @NotNull   @Valid
        PersonRequestRegistrationData person,
        String workPhone,
        String enrollment,
        Subject subject
) {
}
