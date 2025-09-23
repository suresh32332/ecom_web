package com.suresh.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @NotFound // this come form jakarta persistance
    @Column(unique = true)
    private String categoryId;
    @ManyToOne
    private Category parentCategory;
    @NotFound
    private Integer level;
}
