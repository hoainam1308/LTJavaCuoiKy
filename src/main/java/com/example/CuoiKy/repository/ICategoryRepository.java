package com.example.CuoiKy.repository;

import com.example.CuoiKy.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
