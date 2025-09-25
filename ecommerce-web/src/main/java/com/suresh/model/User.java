package com.suresh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.suresh.domain.USER_ROLE;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String fullName;
    private String email;
    private String mobile;
    private USER_ROLE role;
    @OneToMany
    private Set<Address> address = new HashSet<>();
    @ManyToMany
    @JsonIgnore
    private Set<Coupon> coupon = new HashSet<>();

}

