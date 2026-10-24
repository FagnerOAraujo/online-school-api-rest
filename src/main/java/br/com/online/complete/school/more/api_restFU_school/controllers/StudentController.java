package br.com.online.complete.school.more.api_restFU_school.controllers;

import br.com.online.complete.school.more.api_restFU_school.domain.students.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository repository;
}
