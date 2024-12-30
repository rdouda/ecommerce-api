package com.raddaoui.rayen.Serives;

import com.raddaoui.rayen.Models.User;
import com.raddaoui.rayen.Repositories.CardRepository;
import com.raddaoui.rayen.Repositories.UserRepository;
import com.raddaoui.rayen.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserImplementation {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CardRepository cardRepository;

    public ResponseEntity<List<UserDto>> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = users
                .stream()
                .map(UserDto::customMapping)
                .toList();
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    public ResponseEntity<UserDto> findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        assert user != null;
        return new ResponseEntity<>(UserDto.customMapping(user), HttpStatus.OK);
    }

    public ResponseEntity<UserDto> save(UserDto user) {
        User newUser = new User();
        newUser.username=user.username;
        newUser.password=user.password;
        newUser.email=user.email;
        newUser.cards = new ArrayList<>();
        userRepository.save(newUser);
        return new ResponseEntity<>(UserDto.customMapping(newUser), HttpStatus.OK);
    }

    public ResponseEntity<UserDto> update(UserDto user) {
        User newUser = userRepository.findById(user.id).orElse(null);
        assert newUser != null;
        newUser.username=user.username;
        newUser.password=user.password;
        newUser.email=user.email;
        newUser.cards.clear();
        List<Long> cardsId = user.cards
                .stream()
                .map(cardDto -> cardDto.id)
                .toList();
        newUser.cards = cardRepository.findAllById(cardsId);
        userRepository.save(newUser);
        return new ResponseEntity<>(UserDto.customMapping(newUser), HttpStatus.OK);
    }

    public ResponseEntity<UserDto> delete(Long id) {
        User user = userRepository.findById(id).orElse(null);
        assert user != null;
        userRepository.delete(user);
        return new ResponseEntity<>(UserDto.customMapping(user), HttpStatus.OK);
    }
}
