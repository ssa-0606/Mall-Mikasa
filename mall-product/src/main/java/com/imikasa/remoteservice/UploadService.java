package com.imikasa.remoteservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Mikasa
 */
@Service
@FeignClient("UPLOAD-SERVER-9000")
public interface UploadService {

    @PostMapping(value = "/upload/uploadImg",consumes = "multipart/form-data")
    public String uploadImg(@RequestPart("img-file") MultipartFile file);

}
