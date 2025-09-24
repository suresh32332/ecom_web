package com.suresh.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User customer;
    @OneToOne
    private Order order;
    @ManyToOne
    private Seller seller;
    private LocalDateTime date =LocalDateTime.now();
}
