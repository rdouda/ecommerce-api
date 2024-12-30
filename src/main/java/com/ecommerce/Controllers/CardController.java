package com.ecommerce.Controllers;

import com.ecommerce.Serives.CardImplementation;
import com.ecommerce.dto.CardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardImplementation cardImplementation;

    @GetMapping("/all")
    public ResponseEntity<List<CardDto>> getAllCards(){
        return cardImplementation.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<CardDto> getById(@PathVariable("id") Long id){
        return cardImplementation.findById(id);
    }
    @PostMapping("/create")
    public ResponseEntity<CardDto> createCard(@RequestBody CardDto card){
        return cardImplementation.save(card);
    }

    @PatchMapping("/update")
    public ResponseEntity<CardDto> updateCard(@RequestBody CardDto card){
        return cardImplementation.update(card);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CardDto> deleteCard(@PathVariable("id") Long id){
        return cardImplementation.delete(id);
    }

}
