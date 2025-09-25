package com.suresh.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
    @ManyToOne
    private Product product;
    private String size;
    private int quantity=1;
    private Integer mrpPrice;
    private Integer sellingPrice;
    private Long userId;




}
