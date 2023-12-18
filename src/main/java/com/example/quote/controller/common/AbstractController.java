package com.example.quote.controller.common;

import com.example.quote.model.common.AbstractEntity;
import com.example.quote.repository.common.AbstractRepository;
import com.example.quote.service.common.AbstractService;
import com.example.quote.utils.PageSetting;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RequiredArgsConstructor
public abstract class AbstractController<T extends AbstractEntity, S extends AbstractService<T, R>, R extends AbstractRepository<T>> {
    protected final S service;

    @GetMapping("{id}")
    public T getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }

    @GetMapping
    public Page<T> getAllEntities(PageSetting pageSettings) {
        return service.getAllEntities(pageSettings);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEntityById(@PathVariable Long id) {
        service.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}