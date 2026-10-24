package br.com.online.complete.school.more.api_restFU_school.domain.students;

import br.com.online.complete.school.more.api_restFU_school.domain.people.PersonEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "StudentEntity")
@Table(name = "students")
@Getter
@NoArgsConstructor
public class StudentEntity extends PersonEntity {
}
