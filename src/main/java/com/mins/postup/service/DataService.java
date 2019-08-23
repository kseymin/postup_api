package com.mins.postup.service;

import com.mins.postup.entity.CardContent;
import com.mins.postup.entity.Data;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public interface DataService {
    List<Data> findAll();
    Optional<Data> findById(Integer id);

    Optional<Data> findByName(String name);


    Data delete(Integer data_id);

    //Data update(Integer id,MultipartFile file);

    Data storeFile(Integer cardContent_id ,MultipartFile file);

    //download 할때 path가져오기
    Path load(String filename);

    Resource downlaodFile(Integer id);

    List<Data> findByCardContent(CardContent cardContent);

    //application이 시작할때 원래있던거 지우기위한 메소드
    void init();
    void deleteAll();
}
