package com.mins.postup.controller;

import com.mins.postup.entity.Data;
import com.mins.postup.service.DataService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    DataService dataService;

    @GetMapping("/findall")
    public List<Data> findall(){
        return dataService.findAll();
    }



    @PostMapping("/id")
    public Optional<Data> findbyId(@RequestBody Map<String, Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        return dataService.findById(id);
    }

    //delete
    @DeleteMapping("/id")
    public Data delete(@RequestBody Map<String, Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        return dataService.delete(id);

    }



    @PostMapping("/upload")
    public Data upload(@RequestParam("cc_id") Integer cc_id , @RequestParam("file") MultipartFile file){
        return dataService.storeFile(cc_id,file);
    }

    @PostMapping("/download")
    public ResponseEntity<Resource> download(@RequestBody Map<String, Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());

        Optional<Data> tmpdata = dataService.findById(id);
        Data data = tmpdata.get();

        Resource file = dataService.downlaodFile(data.getId());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


    //http://localhost:8080/data/download/PostUp_img_sample.png
    @GetMapping("/download/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Optional<Data> tmpdata = dataService.findByName(filename);
        Data data = tmpdata.get();

        Resource file = dataService.downlaodFile(data.getId());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }



}
