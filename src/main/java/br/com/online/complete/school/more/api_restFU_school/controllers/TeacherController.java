package br.com.online.complete.school.more.api_restFU_school.controllers;

import br.com.online.complete.school.more.api_restFU_school.domain.teachers.*;
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
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherRepository repository;

    @PostMapping("/created")
    @Transactional
    public ResponseEntity createTeacher(
            @RequestBody
            @Valid
            TeacherRequestRegistrationData data,
            UriComponentsBuilder componentsBuilder
    ) {
        var teacher = new TeacherEntity(data);
        repository.save(teacher);
        var uri = componentsBuilder.path("/teachers/created/{id}").buildAndExpand(teacher.getId()).toUri();
        var teacherCreatedNew = new TeacherResponseData(teacher);
        return ResponseEntity.created(uri).body(teacherCreatedNew);
    }

    @GetMapping
    public ResponseEntity<Page<TeacherListData>> getAllTeachers(
            @PageableDefault(size = 10, sort = {"name"})
            Pageable paginacao
    ) {
        var page = repository.findAll(paginacao).map(TeacherListData::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity updateTeacher(
            @RequestBody
            @Valid
            TeacherUpdateData data
    ) {
        var teacher = repository.getReferenceById(data.person().id());
        teacher.updateData(data);
        var teacherUpdateData = new TeacherResponseData(teacher);
        return ResponseEntity.ok(teacherUpdateData);
    }

    @GetMapping("/created/{id}")
    public ResponseEntity findTeacherById(
            @PathVariable
            Long id
    ) {
        var teacher = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
        var teacherDetails = new TeacherResponseData(teacher);
        return ResponseEntity.ok(teacherDetails);
    }


}
