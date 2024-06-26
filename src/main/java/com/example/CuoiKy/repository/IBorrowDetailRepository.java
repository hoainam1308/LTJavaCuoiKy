package com.example.CuoiKy.repository;

import com.example.CuoiKy.entity.BorrowDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowDetailRepository extends JpaRepository<BorrowDetail, Long> {
}
