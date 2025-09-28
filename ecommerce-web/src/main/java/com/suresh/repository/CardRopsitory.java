package com.suresh.repository;

import com.suresh.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRopsitory extends JpaRepository<Card,Long> {
}
