package br.com.online.complete.school.more.api_restFU_school.controllers;

import br.com.online.complete.school.more.api_restFU_school.domain.students.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository repository;

    @PostMapping("/created")
    @Transactional
    public ResponseEntity createStudent(
            @RequestBody
            @Valid
            StudentRequestRegistrationData data,
            UriComponentsBuilder componentsBuilder
    ) {
        var student = new StudentEntity(data);
        repository.save(student);
        var uri = componentsBuilder.path("/students/created/{id}").buildAndExpand(student.getId()).toUri();
        var studentCreatedNew = new StudentResponseData(student);
        return ResponseEntity.created(uri).body(studentCreatedNew);
    }

    @GetMapping
    public ResponseEntity<Page<StudentListData>> getAllStudents(
            @PageableDefault(size = 10, sort = {"name"})
            Pageable paginacao
    ) {
        var page = repository.findAllByActiveTrue(paginacao).map(StudentListData::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity updateStudent(
            @RequestBody
            @Valid
            StudentUpdateData data
    ) {
        var student = repository.getReferenceById(data.person().id());
        student.updateData(data);
        var studentDataUpdate = new StudentResponseData(student);
        return ResponseEntity.ok(studentDataUpdate);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity deactivateStudent(
            @PathVariable
            Long id
    ) {
        var student = repository.getReferenceById(id);
        student.deactivateRegistration();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/created/{id}")
    public ResponseEntity findStudentById(
            @PathVariable
            Long id
    ) {
        var student = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        var sudentDetails = new StudentResponseData(student);
        return ResponseEntity.ok(sudentDetails);
    }
}
