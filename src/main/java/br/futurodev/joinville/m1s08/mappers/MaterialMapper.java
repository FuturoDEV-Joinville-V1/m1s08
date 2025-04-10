package br.futurodev.joinville.m1s08.mappers;

import br.futurodev.joinville.m1s08.dtos.MaterialRequestDto;
import br.futurodev.joinville.m1s08.dtos.MaterialResponseDto;
import br.futurodev.joinville.m1s08.entities.Material;

public class MaterialMapper {

    private MaterialMapper() {}

    public static Material toEntity(MaterialRequestDto dto) {
        Material material = new Material();
        material.setName(dto.name());
        material.setDescription(dto.description());
        return material;
    }

    public static MaterialResponseDto toDto(Material material) {
        return new MaterialResponseDto(
                material.getId(),
                material.getName(),
                material.getDescription()
        );
    }

}
