package com.mins.postup.service;

import com.mins.postup.entity.CardContent;
import com.mins.postup.entity.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface DataService {
    List<Data> findAll();
    Optional<Data> findById(Integer id);

    Data making(Integer cardContent_id, String datafiles);

    Data delete(Integer data_id);
}
