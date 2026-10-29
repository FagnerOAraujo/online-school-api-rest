package br.com.online.complete.school.more.api_restFU_school.controllers;

import br.com.online.complete.school.more.api_restFU_school.domain.directors.*;
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
@RequestMapping("/directors")
public class DirectorController {
    @Autowired
    private DirectorRepository repository;

    @PostMapping("/created")
    @Transactional
    public ResponseEntity createDirector(
            @RequestBody
            @Valid
            DirectorRequestRegistrationData data,
            UriComponentsBuilder componentsBuilder
    ) {
        var director = new DirectorEntity(data);
        repository.save(director);
        var uri = componentsBuilder.path("/directors/created/{id}").buildAndExpand(director.getId()).toUri();
        var directorCreatedNew = new DirectorResponseData(director);
        return ResponseEntity.created(uri).body(directorCreatedNew);
    }

    @GetMapping
    public ResponseEntity<Page<DirectorListData>> getAllDirectors(
            @PageableDefault(size = 10, sort = {"name"})
            Pageable paginacao
    )  {
        var page = repository.findAll(paginacao).map(DirectorListData::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity updateDirector(
            @RequestBody
            @Valid
            DirectorUpdateData data
    ) {
        var director = repository.getReferenceById(data.person().id());
        director.updateData(data);
        var directorUpdateData = new DirectorResponseData(director);
        return ResponseEntity.ok(directorUpdateData);
    }
}
