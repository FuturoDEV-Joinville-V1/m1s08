package br.futurodev.joinville.m1s08.controllers;

import br.futurodev.joinville.m1s08.dtos.CategoryResponseDto;
import br.futurodev.joinville.m1s08.entities.Category;
import br.futurodev.joinville.m1s08.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public List<CategoryResponseDto> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public CategoryResponseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

}
