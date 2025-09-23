package com.suresh.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CardItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    @JsonIgnore
    private Card card;
    private Product product;
    private String size;
    private int quantity=1;
    private Integer mrpPrice;
    private Integer sellingPrice;
    private Long userId;




}
