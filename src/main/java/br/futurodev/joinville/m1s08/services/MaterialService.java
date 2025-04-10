package br.futurodev.joinville.m1s08.services;

import br.futurodev.joinville.m1s08.dtos.MaterialRequestDto;
import br.futurodev.joinville.m1s08.dtos.MaterialResponseDto;
import br.futurodev.joinville.m1s08.entities.Material;
import br.futurodev.joinville.m1s08.mappers.MaterialMapper;
import br.futurodev.joinville.m1s08.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository repository;

    public List<MaterialResponseDto> findAll(String search) {
        List<Material> materials;
        if (search == null || search.isEmpty()) {
            materials = repository.findAll();
        } else {
            materials = repository.findByNameOrDescription(search);
        }

        List<MaterialResponseDto> response = new ArrayList<>();
        for (Material material : materials) {
            response.add(MaterialMapper.toDto(material));
        }
        return response;
    }

    public MaterialResponseDto findById(Long id) {
        Optional<Material> materialOpt = repository.findById(id);
        if (materialOpt.isPresent()) {
            Material material = materialOpt.get();
            return MaterialMapper.toDto(material);
        }
        return null;
    }

    public MaterialResponseDto create(MaterialRequestDto dto) {
        Material material = MaterialMapper.toEntity(dto);

        material = repository.save(material);

        return MaterialMapper.toDto(material);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
