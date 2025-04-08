package br.futurodev.joinville.m1s08.repositories;

import br.futurodev.joinville.m1s08.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
