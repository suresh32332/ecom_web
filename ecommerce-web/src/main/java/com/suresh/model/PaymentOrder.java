package com.suresh.model;

import com.suresh.domain.PaymentMethod;
import com.suresh.domain.PaymentOrderStatus;
import jakarta.persistence.*;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long amount;
    private PaymentOrderStatus paymentOrderStatus = PaymentOrderStatus.PENDING;
    private PaymentMethod paymentMethod;
    private String paymentLinkId;
    @ManyToOne
    private User user;
    @OneToMany
    private Set<Order> order = new HashSet<>();

}
