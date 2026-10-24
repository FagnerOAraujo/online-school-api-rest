package br.com.online.complete.school.more.api_restFU_school.controllers;

import br.com.online.complete.school.more.api_restFU_school.domain.teachers.TeacherEntity;
import br.com.online.complete.school.more.api_restFU_school.domain.teachers.TeacherRepository;
import br.com.online.complete.school.more.api_restFU_school.domain.teachers.TeacherRequestRegistrationData;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        var uri = componentsBuilder.path("/teachers/{id}").buildAndExpand(teacher.getId()).toUri();
        return ResponseEntity.created(uri).body("Uau... Professor cadastrado com sucesso no banco! ");
    }
}
