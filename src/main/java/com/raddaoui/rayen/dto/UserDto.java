package com.raddaoui.rayen.dto;

import com.raddaoui.rayen.Models.Card;
import com.raddaoui.rayen.Models.User;

import java.util.ArrayList;
import java.util.List;


public class UserDto {

    public Long id;
    public String fullName;
    public String email;
    public String username;
    public String password;
    public List<CardDto> cards;

    public static UserDto customMapping(User user) {
        UserDto dto = new UserDto();
        dto.id = user.id;
        dto.fullName = user.fullName;
        dto.email = user.email;
        dto.username = user.username;
        dto.password = user.password;
        List<CardDto> cards = new ArrayList<>();
        for (Card card : user.cards) {
            cards.add(CardDto.customMapping(card));
        }
        dto.cards = cards;
        return dto;
    }
}
