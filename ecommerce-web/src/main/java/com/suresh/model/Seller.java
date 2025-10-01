package com.suresh.model;

import com.suresh.domain.AccountStatus;
import com.suresh.domain.USER_ROLE;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sellerName;
    private String mobile;
    @Column(unique = true, nullable = true)
    private String email;
    private String password;
    @Embedded
    private BusinessDetails businessDetails = new BusinessDetails();
    @Embedded
    private BankDetails bankDetails = new BankDetails();
   @OneToOne
    private Address pickupAddress = new Address();
   private String GSTIN;
   private USER_ROLE role =USER_ROLE.ROLE_SELLER;
   private boolean isEmailVerified =false;
   private AccountStatus accountStatus =  AccountStatus.PENDING_VERIFICATION;


}
