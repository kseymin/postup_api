package com.mins.postup.repogitory;

import com.mins.postup.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepogitory extends JpaRepository<Card,Integer> {
}
