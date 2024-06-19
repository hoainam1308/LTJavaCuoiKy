package com.example.CuoiKy.repository;

import com.example.CuoiKy.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
