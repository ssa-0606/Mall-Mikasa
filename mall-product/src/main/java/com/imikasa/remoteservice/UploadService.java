package com.imikasa.remoteservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Mikasa
 */
@Service
@FeignClient("UPLOAD-SERVER-9000")
public interface UploadService {

    @PostMapping("uploadImg")
    public String uploadImg(MultipartFile file);

}
