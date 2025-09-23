package com.suresh.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private User user;
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<CardItem> cardItem = new HashSet<>();
    private double totalSellingPrice;
    private int totalItem;
    private int totalMrpPrice;
    private int discount;
    private String couponCode;
}

