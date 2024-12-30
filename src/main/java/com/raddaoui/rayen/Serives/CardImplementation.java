package com.raddaoui.rayen.Serives;

import com.raddaoui.rayen.Models.Card;
import com.raddaoui.rayen.Models.Item;
import com.raddaoui.rayen.Models.User;
import com.raddaoui.rayen.Repositories.CardRepository;
import com.raddaoui.rayen.Repositories.ItemRepository;
import com.raddaoui.rayen.Repositories.UserRepository;
import com.raddaoui.rayen.dto.CardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardImplementation {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    public ResponseEntity<List<CardDto>> findAll() {
        List<Card> cards = cardRepository.findAll();
        List<CardDto> cardsDto = cards
                .stream()
                .map(CardDto::customMapping)
                .toList();
        
        return new ResponseEntity<>(cardsDto, HttpStatus.OK);
    }

    public ResponseEntity<CardDto> findById(Long id) {
        Card card = cardRepository.findById(id).orElse(null);
        assert card != null;
        return new ResponseEntity<>(CardDto.customMapping(card), HttpStatus.OK);
    }

    public ResponseEntity<CardDto> save(CardDto card) {
        User user = userRepository.findById(card.userId).get();
        List<Long> itemIds = card.items
                .stream()
                .map(item -> item.id)
                .collect(Collectors.toList());
        List<Item> items = itemRepository.findAllById(itemIds);
        Card newCard = new Card();
        newCard.items = items;
        newCard.user = user;
        cardRepository.save(newCard);
        return new ResponseEntity<>(CardDto.customMapping(newCard), HttpStatus.OK);
    }

    public ResponseEntity<CardDto> update(CardDto card) {
        Card updateCard = cardRepository.findById(card.id).get();
        User user = userRepository.findById(card.userId).get();
        List<Long> itemIds = card.items
                .stream()
                .map(item -> item.id)
                .collect(Collectors.toList());
        List<Item> items = itemRepository.findAllById(itemIds);
        updateCard.items = items;
        updateCard.user = user;
        cardRepository.save(updateCard);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    public ResponseEntity<CardDto> delete(Long id) {
        Card card = cardRepository.findById(id).orElse(null);
        assert card != null;
        cardRepository.delete(card);
        return new ResponseEntity<>(CardDto.customMapping(card), HttpStatus.OK);
    }
}
