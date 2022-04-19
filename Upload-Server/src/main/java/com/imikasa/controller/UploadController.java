package com.imikasa.controller;

import com.imikasa.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Mikasa
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping(value = "/uploadImg",consumes = "multipart/form-data")
    public String uploadImg(@RequestPart("img-file") MultipartFile file){
        String upload = uploadService.upload(file);
        return upload;
    }

}
