package com.mins.postup.repogitory;

import com.mins.postup.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepogitory extends JpaRepository<Data,Integer> {
}
