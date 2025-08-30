package com.mybank.BankingApplication.service;

import com.mybank.BankingApplication.model.Card;
import com.mybank.BankingApplication.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private  CardRepository cardRepository;

    public List<Card> getCardDetails() {
        return cardRepository.findAll();
    }
    public Card getCardById(Long id){
        return cardRepository.findById(id).orElseThrow(()->new RuntimeException("card not found with id "+id));
    }
    public Card createCard(Card card){
        Card ca=new Card();
        ca.setCardNumber(card.getCardNumber());
        ca.setCardType(card.getCardType());
        ca.setExpiryDate(card.getExpiryDate());
        ca.setCvv(card.getCvv());
        ca.setActive(card.isActive());
        return cardRepository.save(ca);
    }
    public Card updateCard(Long id,Card card){
        Card existing =cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("card not found with id"+id));
        existing.setCardNumber(card.getCardNumber());
        existing.setCardType(card.getCardType());
        existing.setCvv(card.getCvv());
        existing.setExpiryDate(card.getExpiryDate());
        existing.setActive(card.isActive());
        return cardRepository.save(existing);
    }
    public void deleteCard(Long id){
        if(!cardRepository.existsById(id)){
            throw new RuntimeException("Account not found with id "+id);
        }
        cardRepository.deleteById(id);
    }
}
