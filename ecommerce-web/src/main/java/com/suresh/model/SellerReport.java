package com.suresh.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SellerReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Seller seller;
    private Long totalEarnings =0L;
    private Long  totalSales= 0L;
    private Long totalRefunds=0L;
    private Long totalTax = 0L;
    private Long netEarnings =0L;
    private Integer totalOrders =0;
    private Integer canceledOrder=0;
    private Integer totalTransaction =0;

}
