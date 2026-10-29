package br.com.online.complete.school.more.api_restFU_school.domain.directors;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonEntity;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "DirectorEntity")
@Table(name = "directors")
@Getter
@NoArgsConstructor
public class DirectorEntity extends PersonEntity {
    @Column(name = "businessPhone")
    private String businessPhone;
    @Column(name = "professionalRegistration")
    private String professionalRegistration;
    @Enumerated(EnumType.STRING)
    private DirectorPosition position;
    @Column(name = "appointmentDate")
    private LocalDate appointmentDate;
    @Column(name = "termEndDate")
    private LocalDate termEndDate;

    public DirectorEntity(
            @Valid
            DirectorRequestRegistrationData data
    ) {
        super(data.person());
        this.businessPhone = data.businessPhone();
        this.professionalRegistration = data.professionalRegistration();
        this.position = data.position();
        this.appointmentDate = data.appointmentDate();
        this.termEndDate = data.termEndDate();
    }

    public void updateData(@Valid DirectorUpdateData data) {
        super.updateData(data.person());
        if (data.businessPhone() != null) {
            this.businessPhone = data.businessPhone();
        }
        if (data.professionalRegistration() != null) {
            this.professionalRegistration = data.professionalRegistration();
        }
        if (data.appointmentDate() != null) {
            this.appointmentDate = data.appointmentDate();
        }
        if (data.termEndDate() != null) {
            this.termEndDate = data.termEndDate();
        }
    }
}
