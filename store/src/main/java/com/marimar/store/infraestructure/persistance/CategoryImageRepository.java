package com.marimar.store.infraestructure.persistance;

import com.marimar.store.domain.entity.CategoryImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryImageRepository extends JpaRepository<CategoryImage, Long> {
}
