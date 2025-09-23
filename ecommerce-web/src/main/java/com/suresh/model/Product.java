package com.suresh.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private int sellingPrice;
    private int discountPercent;
    private int Quantuty;
    @ManyToOne
    private Category category;
    private String numRatings;
    @ManyToOne
    private Seller seller;
    private LocalDateTime localDate;
    private String Sizes;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Review> review = new ArrayList<>();


}
