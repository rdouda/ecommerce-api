package com.ecommerce.dto;

import com.ecommerce.Models.Card;
import com.ecommerce.Models.Item;

import java.util.ArrayList;
import java.util.List;

public class CardDto {

    public Long id;
    public Long userId;
    public List<ItemDto> items;

    public static CardDto customMapping(Card card) {
        CardDto cardDto = new CardDto();
        cardDto.id = card.id;
        cardDto.userId = card.user.id;
        List<ItemDto> items = new ArrayList<>();
        for (Item item : card.items) {
            items.add(ItemDto.customMapping(item));
        }
        cardDto.items = items;

        return cardDto;
    }
}
