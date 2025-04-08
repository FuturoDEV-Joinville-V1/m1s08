package br.futurodev.joinville.m1s08.services;

import br.futurodev.joinville.m1s08.entities.Material;
import br.futurodev.joinville.m1s08.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository repository;

    public List<Material> findAll() {
        return repository.findAll();
    }

}
