package com.suresh.model;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer discount;
    @OneToOne
    private HomeCategory homeCategory;
}
