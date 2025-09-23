package com.suresh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String reviewText;
    @Column(nullable = false)
    private double rating;
    @ElementCollection
    private List<String> productImage;
    @ManyToOne
    @JsonIgnore
    @Column(nullable = false)
    private Product product;
    @ManyToOne
    @Column(nullable = false)
    private User user;
    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();
}
