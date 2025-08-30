package com.mybank.BankingApplication.controller;

import com.mybank.BankingApplication.model.Card;
import com.mybank.BankingApplication.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {
    private final CardService cardService;
    CardController(CardService cardService ){
        this.cardService=cardService;
    }
    @GetMapping("/cardDetails")
    public ResponseEntity<List<Card>> getCardDetails(){
        return ResponseEntity.ok(cardService.getCardDetails());
    }
@GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id){
        return ResponseEntity.ok(cardService.getCardById(id));
}
@PostMapping("/save")
public ResponseEntity<Card> createCard(@RequestBody Card card){
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.createCard(card));
}
@PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Long id,@RequestBody Card card){
        return ResponseEntity.ok(cardService.updateCard(id,card));
}
@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCard(Long id){
        cardService.deleteCard(id);
        return ResponseEntity.ok("card deleted successfully");
}
}
