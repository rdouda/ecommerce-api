package com.raddaoui.rayen.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "fullName")
    public String fullName;


    @Column(name = "email", unique = true)
    public String email;

    @Column(name = "username", unique = true)
    public String username;

    @Column(name = "password")
    public String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Card> cards;
}
