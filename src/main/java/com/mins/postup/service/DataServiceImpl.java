package com.mins.postup.service;

import com.mins.postup.entity.CardContent;
import com.mins.postup.entity.Data;
import com.mins.postup.exception.StorageException;
import com.mins.postup.exception.StorageFileNotFoundException;
import com.mins.postup.repogitory.DataRepogitory;
import com.mins.postup.storage.StorageProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class DataServiceImpl implements DataService{
    @Autowired
    DataRepogitory dataRepogitory;

    @Autowired
    CardContentService cardContentService;

    private final Path rootLocation;

    @Autowired
    public DataServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }



    @Override
    public List<Data> findAll() {
        return dataRepogitory.findAll();
    }

    @Override
    public Optional<Data> findById(Integer id) {
        return dataRepogitory.findById(id);
    }

    @Override
    public Optional<Data> findByName(String name) {
        return dataRepogitory.findByName(name);
    }


    //delete
    @Override
    public Data delete(Integer data_id) {
        Optional<Data> tmpdata = dataRepogitory.findById(data_id);
        Data data = tmpdata.get();


        Path uri = this.rootLocation.resolve(data.getName()) ;

        try {
            FileSystemUtils.deleteRecursively(uri);
            dataRepogitory.delete(data);
        }catch (IOException e) {
            throw new StorageException("Could not delete file", e);
        }

        return data;
    }




    @Override
    public Data storeFile(Integer cardContent_id, MultipartFile file) {
        // Normalize file name
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);


            }
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }


        Optional<CardContent> tmpcc = cardContentService.findById(cardContent_id);
        CardContent cc = tmpcc.get(); // need error process

        Data datas = new Data(cc, filename,this.rootLocation.resolve(filename).toString());


        dataRepogitory.save(datas);


        return datas;
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }


    @Override
    public Resource downlaodFile(Integer id) {
        Optional<Data> tmpdata = dataRepogitory.findById(id);
        Data data = tmpdata.get();

        String filename = data.getName();

        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }

    }

    @Override
    public List<Data> findByCardContent(CardContent cardContent) {
//        Optional<Data> tmpdata = dataRepogitory.findById(data_id);
//        Data data = tmpdata.get();

        List<Data> dataList = dataRepogitory.findByCardContent(cardContent);

        return dataList;
    }

    // 처음시작시 로컬 시스템에있는 파일삭제하기위해 필요

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }


}
