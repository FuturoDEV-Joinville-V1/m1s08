package br.futurodev.joinville.m1s08.services;

import br.futurodev.joinville.m1s08.dtos.CategoryResponseDto;
import br.futurodev.joinville.m1s08.dtos.MaterialRequestDto;
import br.futurodev.joinville.m1s08.dtos.MaterialResponseDto;
import br.futurodev.joinville.m1s08.entities.Category;
import br.futurodev.joinville.m1s08.entities.Material;
import br.futurodev.joinville.m1s08.mappers.CategoryMapper;
import br.futurodev.joinville.m1s08.mappers.MaterialMapper;
import br.futurodev.joinville.m1s08.repositories.CategoryRepository;
import br.futurodev.joinville.m1s08.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<CategoryResponseDto> findAll() {
        return repository.findAll().stream()
                .map(
                        (category) -> CategoryMapper.toDto(category)
                ).toList();
    }

    public CategoryResponseDto findById(Long id) {
        return CategoryMapper.toDto(findEntityById(id));
    }

    public Category findEntityById(Long id) {
        Optional<Category> categoryOpt = repository.findById(id);
        if (categoryOpt.isPresent()) {
            return categoryOpt.get();
        }
        return null;
    }
}
