package br.futurodev.joinville.m1s08.mappers;

import br.futurodev.joinville.m1s08.dtos.CategoryResponseDto;
import br.futurodev.joinville.m1s08.entities.Category;

public class CategoryMapper {

    private CategoryMapper() {}

    public static CategoryResponseDto toDto(Category category) {
        if (category == null) {
            return null;
        }
        return new CategoryResponseDto(
                category.getId(),
                category.getName()
        );
    }

}
