package com.example.CuoiKy.service;

import com.example.CuoiKy.entity.Book;
import com.example.CuoiKy.entity.Borrow;
import com.example.CuoiKy.entity.Card;
import com.example.CuoiKy.repository.IBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {
    @Autowired
    private IBorrowRepository borrowRepository;

    public List<Borrow> getAllBorrow(){return borrowRepository.findAll();}

    public Borrow getById(Long id){
        return borrowRepository.findById(id).orElse(null);
    }

    public void addBorrow(Borrow borrow){
        borrowRepository.save(borrow);
    }

    public void deleteBorrowById(Long id){
        borrowRepository.deleteById(id);
    }

    public void updateBorrow(Borrow borrow){
        borrowRepository.save(borrow);
    }
}
