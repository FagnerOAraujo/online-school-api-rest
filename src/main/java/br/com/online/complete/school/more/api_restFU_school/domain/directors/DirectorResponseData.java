package br.com.online.complete.school.more.api_restFU_school.domain.directors;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonResponseData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record DirectorResponseData(
        PersonResponseData person,
        String businessPhone,
        String professionalRegistration,
        DirectorPosition position,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate appointmentDate,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate termEndDate
) {
    public DirectorResponseData(
            DirectorEntity entity
    )   {
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
                entity.getBusinessPhone(),
                entity.getProfessionalRegistration(),
                entity.getPosition(),
                entity.getAppointmentDate(),
                entity.getTermEndDate()
        );
    }
}
