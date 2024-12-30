package com.raddaoui.rayen.Controllers;

import com.raddaoui.rayen.Serives.ItemImplementation;
import com.raddaoui.rayen.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemImplementation itemImplementation;

    @GetMapping("/all")
    public ResponseEntity<List<ItemDto>> getAllItems(){
        return itemImplementation.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemDto> getById(@PathVariable("id") Long id){
        return itemImplementation.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto item){
        return itemImplementation.save(item);
    }

    @PatchMapping("/update")
    public ResponseEntity<ItemDto> updateItem(@RequestBody ItemDto item){
        return itemImplementation.update(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemDto> deleteItem(@PathVariable("id") Long id){
        return itemImplementation.delete(id);
    }
    
}
