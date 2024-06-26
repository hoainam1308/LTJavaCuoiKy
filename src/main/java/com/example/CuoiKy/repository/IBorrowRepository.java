package com.example.CuoiKy.repository;

import com.example.CuoiKy.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowRepository extends JpaRepository<Borrow, Long> {
}
