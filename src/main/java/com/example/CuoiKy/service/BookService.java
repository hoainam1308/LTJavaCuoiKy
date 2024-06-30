package com.example.CuoiKy.service;

import com.example.CuoiKy.entity.Book;
import com.example.CuoiKy.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public List<Book> filterBook(Long cateId, Integer page, Long authorId){
        return bookRepository.filterBook(cateId, page, authorId);
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