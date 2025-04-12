package br.futurodev.joinville.m1s08.controllers;

import br.futurodev.joinville.m1s08.dtos.MaterialRequestDto;
import br.futurodev.joinville.m1s08.dtos.MaterialResponseDto;
import br.futurodev.joinville.m1s08.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materials")
public class MaterialController {

    @Autowired
    private MaterialService service;

    @GetMapping
    public List<MaterialResponseDto> get(String search) {
        return service.findAll(search);
    }

    @GetMapping("{id}")
    public MaterialResponseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MaterialResponseDto post(@RequestBody MaterialRequestDto dto) {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public MaterialResponseDto put(@PathVariable Long id, @RequestBody MaterialRequestDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
