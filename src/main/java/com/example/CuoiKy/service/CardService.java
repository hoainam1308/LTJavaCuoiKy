package com.example.CuoiKy.service;

import com.example.CuoiKy.entity.Card;
import com.example.CuoiKy.repository.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private ICardRepository cardRepository;

    public List<Card> getAllCard(){return cardRepository.findAll();}

    public Card getById(Long id){
        return cardRepository.findById(id).orElse(null);
    }

    public void addCard(Card card){
        cardRepository.save(card);
    }

    public void deleteCardById(Long id){
        cardRepository.deleteById(id);
    }

    public void updateCard(Card card){
        cardRepository.save(card);
    }
}
