package com.mins.postup.service;

import com.mins.postup.entity.CardContent;
import com.mins.postup.entity.Data;
import com.mins.postup.repogitory.DataRepogitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataServiceImpl implements DataService{
    @Autowired
    DataRepogitory dataRepogitory;

    @Autowired
    CardContentService cardContentService;

    @Override
    public List<Data> findAll() {
        return dataRepogitory.findAll();
    }

    @Override
    public Optional<Data> findById(Integer id) {
        return dataRepogitory.findById(id);
    }

    @Override
    public Data making(Integer cardContent_id, String datafiles) {
        Optional<CardContent> tmpcc = cardContentService.findById(cardContent_id);
        CardContent cc = tmpcc.get();

        Data datas= new Data(cc,datafiles);
        dataRepogitory.save(datas);

        return datas;
    }


}
