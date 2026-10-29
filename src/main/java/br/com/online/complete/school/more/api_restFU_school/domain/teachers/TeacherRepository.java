package br.com.online.complete.school.more.api_restFU_school.domain.teachers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    Page<TeacherEntity> findAllByActiveTrue(Pageable paginacao);
}
