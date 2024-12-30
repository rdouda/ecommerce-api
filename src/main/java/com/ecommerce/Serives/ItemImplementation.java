package com.ecommerce.Serives;

import com.ecommerce.Models.Item;
import com.ecommerce.Repositories.ItemRepository;
import com.ecommerce.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemImplementation {

    @Autowired
    private ItemRepository itemRepository;

    public ResponseEntity<List<ItemDto>> findAll() {
        List<Item> items = itemRepository.findAll();
        List<ItemDto> itemsDto = items
                .stream()
                .map(ItemDto::customMapping)
                .toList();
        return new ResponseEntity<>(itemsDto, HttpStatus.OK);
    }

    public ResponseEntity<ItemDto> findById(Long id) {
        Item item = itemRepository.findById(id).orElse(null);
        assert item != null;
        return new ResponseEntity<>(ItemDto.customMapping(item), HttpStatus.OK);
    }

    public ResponseEntity<ItemDto> save(ItemDto item) {
        Item newItem = new Item();
        newItem.name = item.name;
        newItem.description = item.description;
        newItem.price = item.price;
        newItem=itemRepository.save(newItem);
        return new ResponseEntity<>(ItemDto.customMapping(newItem), HttpStatus.OK);
    }

    public ResponseEntity<ItemDto> update(ItemDto item) {
        Item updateItem = itemRepository.findById(item.id).get();
        updateItem.name = item.name;
        updateItem.description = item.description;
        updateItem.price = item.price;
        updateItem= itemRepository.save(updateItem);
        return new ResponseEntity<>(ItemDto.customMapping(updateItem), HttpStatus.OK);
    }

    public ResponseEntity<ItemDto> delete(Long id) {
        Item item = itemRepository.findById(id).orElse(null);
        assert item != null;
        itemRepository.delete(item);
        return new ResponseEntity<>(ItemDto.customMapping(item), HttpStatus.OK);
    }
}
