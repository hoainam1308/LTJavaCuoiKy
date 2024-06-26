package com.example.CuoiKy.service;

import com.example.CuoiKy.entity.BorrowDetail;
import com.example.CuoiKy.repository.IBorrowDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowDetailService {
    @Autowired
    private IBorrowDetailRepository borrowDetailRepository;

    public List<BorrowDetail> getAllBorrowDetail(){return borrowDetailRepository.findAll();}

    public BorrowDetail getById(Long id){
        return borrowDetailRepository.findById(id).orElse(null);
    }

    public void addBorrowDetail(BorrowDetail borrowDetail){
        borrowDetailRepository.save(borrowDetail);
    }

    public void deleteBorrowDetailById(Long id){
        borrowDetailRepository.deleteById(id);
    }

    public void updateBorrowDetail(BorrowDetail borrowDetail){
        borrowDetailRepository.save(borrowDetail);
    }
}
