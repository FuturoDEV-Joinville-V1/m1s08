package br.futurodev.joinville.m1s08.repositories;

import br.futurodev.joinville.m1s08.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
