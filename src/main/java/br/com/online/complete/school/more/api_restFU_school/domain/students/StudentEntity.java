package br.com.online.complete.school.more.api_restFU_school.domain.students;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "StudentEntity")
@Table(name = "students")
@Getter
@NoArgsConstructor
public class StudentEntity extends PersonEntity {
    private String whatsapp;
    private String ra;
    @Column(name = "birthDate")
    private LocalDate birthDate;

    public StudentEntity(@Valid StudentRequestRegistrationData data) {
        super(data.person());
        this.whatsapp = data.whatsapp();
        this.ra = data.ra();
        this.birthDate = data.birthDate();
    }

    public void updateData(
            @Valid
            StudentUpdateData data
    ) {
        super.updateData(data.person());
        if (data.whatsapp() != null) {
            this.whatsapp = data.whatsapp();
        }
        if (data.birthDate() != null) {
            this.birthDate = data.birthDate();
        }
    }

}
