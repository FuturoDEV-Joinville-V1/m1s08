package br.futurodev.joinville.m1s08.services;

import br.futurodev.joinville.m1s08.dtos.MaterialRequestDto;
import br.futurodev.joinville.m1s08.dtos.MaterialResponseDto;
import br.futurodev.joinville.m1s08.entities.Category;
import br.futurodev.joinville.m1s08.entities.Material;
import br.futurodev.joinville.m1s08.mappers.MaterialMapper;
import br.futurodev.joinville.m1s08.repositories.CategoryRepository;
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

    @Autowired
    private CategoryService categoryService;

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
        return MaterialMapper.toDto(findEntityById(id));
    }

    public MaterialResponseDto create(MaterialRequestDto dto) {
        Material material = MaterialMapper.toEntity(dto);
        return save(material, dto);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public MaterialResponseDto update(Long id, MaterialRequestDto dto) {
        Material material = findEntityById(id);

        if (material != null) {
            material = MaterialMapper.toEntity(dto);
            material.setId(id);
            return save(material, dto);
        }
        return null;
    }

    private Material findEntityById(Long id) {
        Optional<Material> materialOpt = repository.findById(id);
        if (materialOpt.isPresent()) {
            return materialOpt.get();
        }
        return null;
    }

    private void setCategoryToMaterial(Material material, Long categoryId) {
        Category category = categoryService.findEntityById(categoryId);
        if (category != null) {
            material.setCategory(category);
        }
    }

    private MaterialResponseDto save(Material material, MaterialRequestDto dto) {
        setCategoryToMaterial(material, dto.categoryId());
        material = repository.save(material);
        return MaterialMapper.toDto(material);
    }
}
