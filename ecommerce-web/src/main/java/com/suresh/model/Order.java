package com.suresh.model;

import com.suresh.domain.OrderStatus;
import com.suresh.domain.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String orderId;
        @ManyToOne
        private User user;
        private Long sellerId;
        @OneToMany(mappedBy = "order",cascade = CascadeType.ALL, orphanRemoval = true)
        private List<OrderItem> orderItems = new ArrayList<>();
        @ManyToOne
        private Address shippingAddress;
        @Embedded
        private PaymentDetails paymentDetails = new PaymentDetails();
        private double totalMrpPrice;
        private Integer sellingPrice;
        private Integer discount;
        private OrderStatus orderStatus;
        private int totalItem;
        private PaymentStatus paymentStatus;
        private LocalDateTime orderDate = LocalDateTime.now();
        private LocalDateTime deliverDate = orderDate.plusDays(7);






}
