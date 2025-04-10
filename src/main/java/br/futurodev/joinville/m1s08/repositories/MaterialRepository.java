package br.futurodev.joinville.m1s08.repositories;

import br.futurodev.joinville.m1s08.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    // Derived Query
    List<Material> findByNameContainingIgnoreCase(String name);

    // JPQL
    @Query("SELECT m " +
            "FROM Material m " +
            "WHERE UPPER(m.name) LIKE '%'||UPPER(:search)||'%'" +
            "   OR UPPER(m.description) LIKE '%'||UPPER(:search)||'%'")
    List<Material> findByNameOrDescription(String search);

}
