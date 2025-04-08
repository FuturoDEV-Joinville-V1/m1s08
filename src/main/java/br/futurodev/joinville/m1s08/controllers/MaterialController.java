package br.futurodev.joinville.m1s08.controllers;

import br.futurodev.joinville.m1s08.entities.Material;
import br.futurodev.joinville.m1s08.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("materials")
public class MaterialController {

    @Autowired
    private MaterialService service;

    @GetMapping
    public List<Material> get() {
        return service.findAll();
    }
}
