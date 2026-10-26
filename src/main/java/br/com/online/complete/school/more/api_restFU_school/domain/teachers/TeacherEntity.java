package br.com.online.complete.school.more.api_restFU_school.domain.teachers;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonEntity;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "TeacherEntity")
@Table(name = "teachers")
@Getter
@NoArgsConstructor
public class TeacherEntity extends PersonEntity {
    @Column(name = "workPhone")
    private String workPhone;
    private String enrollment;
    @Enumerated(EnumType.STRING)
    private Subject subject;

    public TeacherEntity(@Valid TeacherRequestRegistrationData data) {
        super(data.person());
        this.workPhone = data.workPhone();
        this.enrollment = data.enrollment();
        this.subject = data.subject();
            }

    public void updateData(@Valid TeacherUpdateData data) {
        super.updateData(data.person());
        if (data.workPhone() != null) {
            this.workPhone = data.workPhone();
        }
        if (data.subject() != null) {
            this.subject = data.subject();
        }
    }
}
