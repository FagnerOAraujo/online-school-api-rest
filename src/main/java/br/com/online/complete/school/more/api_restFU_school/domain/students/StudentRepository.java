package br.com.online.complete.school.more.api_restFU_school.domain.students;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Page<StudentEntity> findAllByActiveTrue(Pageable paginacao);
}
