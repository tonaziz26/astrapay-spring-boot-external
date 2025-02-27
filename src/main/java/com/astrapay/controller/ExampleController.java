package com.astrapay.controller;

import com.astrapay.dto.ExampleDto;
import com.astrapay.service.ExampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/examples")
@Api(value = "ExampleController")
public class ExampleController {
    private final ExampleService exampleService;

    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @PostMapping
    @ApiOperation(value = "Create a new example")
    public ResponseEntity<ExampleDto> create(@Valid @RequestBody ExampleDto exampleDto) {
        return new ResponseEntity<>(exampleService.create(exampleDto), HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    @ApiOperation(value = "Get example by name")
    public ResponseEntity<ExampleDto> getByName(@PathVariable String name) {
        ExampleDto example = exampleService.getByName(name);
        return example != null ? ResponseEntity.ok(example) : ResponseEntity.notFound().build();
    }

    @GetMapping
    @ApiOperation(value = "Get all examples")
    public ResponseEntity<List<ExampleDto>> getAll() {
        return ResponseEntity.ok(exampleService.getAll());
    }

    @PutMapping("/{name}")
    @ApiOperation(value = "Update example by name")
    public ResponseEntity<ExampleDto> update(@PathVariable String name, @Valid @RequestBody ExampleDto exampleDto) {
        ExampleDto updated = exampleService.update(name, exampleDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{name}")
    @ApiOperation(value = "Delete example by name")
    public ResponseEntity<Void> delete(@PathVariable String name) {
        exampleService.delete(name);
        return ResponseEntity.ok().build();
    }
}