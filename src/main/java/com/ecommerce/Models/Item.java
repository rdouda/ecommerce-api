package com.ecommerce.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "items")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "price")
    public Double price;

}
