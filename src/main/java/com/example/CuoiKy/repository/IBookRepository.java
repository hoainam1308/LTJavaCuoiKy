package com.example.CuoiKy.repository;

import com.example.CuoiKy.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE " +
            "(:cateId IS NULL OR b.category.id = :cateId) AND " +
            "(:page IS NULL OR b.page = :page) AND " +
            "(:authorId IS NULL OR b.author.id = :authorId)")
    List<Book> filterBook(@Param("cateId") Long cateId,
                          @Param("page") Integer page,
                          @Param("authorId") Long authorId);

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Book> searchBook(@Param("query") String query);
}
