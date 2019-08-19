package com.mins.postup.repogitory;

import com.mins.postup.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DataRepogitory extends JpaRepository<Data,Integer> {
    List<Data> findAll();
    Optional<Data> findById(Integer id);
}
