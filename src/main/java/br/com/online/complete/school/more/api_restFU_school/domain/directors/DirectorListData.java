package br.com.online.complete.school.more.api_restFU_school.domain.directors;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonListData;

public record DirectorListData(
        PersonListData person,
        String businessPhone,
        String professionalRegistration,
        DirectorPosition position
        ) {
    public DirectorListData(
            DirectorEntity entity
    )  {
        this(
                new PersonListData(
                        entity.getId(),
                        entity.getName(),
                        entity.getEmail(),
                        entity.getMobilePhone(),
                        entity.getRg(),
                        entity.getMotherName()
                ),
                entity.getBusinessPhone(),
                entity.getProfessionalRegistration(),
                entity.getPosition()
        );
    }
}
