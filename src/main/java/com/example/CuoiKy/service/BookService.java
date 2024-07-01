package com.example.CuoiKy.service;

import com.example.CuoiKy.entity.Book;
import com.example.CuoiKy.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public List<Book> filterBooks(Long authorId, Long categoryId, Integer minPage, Integer maxPage) {
        Specification<Book> spec = Specification.where(null);

        if (authorId != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("author").get("id"), authorId));
        }
        if (categoryId != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category").get("id"), categoryId));
        }
        if (minPage != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("page"), minPage));
        }
        if (maxPage != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("page"), maxPage));
        }

        return bookRepository.findAll(spec);
    }

    public List<Book> searchBook(String query){
        return bookRepository.searchBook(query);
    }

    public List<Book> getByCateId(Long cate_id){
        return bookRepository.getByCateId(cate_id);
    }

    public Long getSetId(Long bookId){
        return bookRepository.getSetId(bookId);
    }

    public List<Book> getBySetId(Long set_id){
        return bookRepository.getBySetId(set_id);
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

}