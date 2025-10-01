package com.suresh.repository;


import com.suresh.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SellerRepository extends JpaRepository<Seller,Long> {
    Seller findByEmail(String email );

}
