package com.raddaoui.rayen.dto;

import com.raddaoui.rayen.Models.Item;

public class ItemDto {

    public Long id;
    public String name;
    public String description;
    public Double price;

    public static ItemDto customMapping(Item item) {
        ItemDto dto = new ItemDto();
        dto.id = item.id;
        dto.name = item.name;
        dto.description = item.description;
        dto.price = item.price;
        return dto;

    }
}
