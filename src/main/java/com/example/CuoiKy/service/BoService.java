package com.example.CuoiKy.service;



import com.example.CuoiKy.entity.Bo;
import com.example.CuoiKy.repository.IBoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoService {
    @Autowired
    IBoRepository boRepository;

    public List<Bo> getAllBo(){
        return boRepository.findAll();
    }

    public Bo getBoById(Long id){
        return boRepository.findById(id).orElse(null);
    }
}
