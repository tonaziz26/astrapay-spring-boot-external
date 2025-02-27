package com.astrapay.service;

import com.astrapay.dto.ExampleDto;
import com.astrapay.exception.ExampleException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ExampleService {
    private final Map<String, ExampleDto> mapStorage = new ConcurrentHashMap<>();

    public ExampleDto create(ExampleDto exampleDto) throws ExampleException {
        if (null != mapStorage.get(exampleDto.getName())) {
            throw new ExampleException("Example with name " + exampleDto.getName() + " already exists");
        }

        mapStorage.put(exampleDto.getName(), exampleDto);
        return exampleDto;
    }

    public ExampleDto getByName(String name) throws ExampleException {
        ExampleDto example = mapStorage.get(name);
        if (example == null) {
            throw new ExampleException("Example with name " + name + " not found");
        }
        return example;
    }

    public List<ExampleDto> getAll() {
        return new ArrayList<>(mapStorage.values());
    }

    public ExampleDto update(String name, ExampleDto exampleDto) throws ExampleException {
        getByName(name);
        mapStorage.put(name, exampleDto);
        return exampleDto;
    }

    public void delete(String name) throws ExampleException {
        getByName(name);
        mapStorage.remove(name);
    }
}