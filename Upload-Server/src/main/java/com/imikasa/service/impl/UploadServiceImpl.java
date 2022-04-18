package com.imikasa.service.impl;

import com.imikasa.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Mikasa
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Value("${upload.url}")
    private String uploadPath;

    @Override
    public String upload(MultipartFile file) {
        if(file!=null){
            try {
                String fileName = System.currentTimeMillis()+file.getOriginalFilename();
                String fileDirPath = uploadPath;
                File filePath = new File(fileDirPath);
                if(!filePath.exists()){
                    filePath.mkdirs();
                }
                File target = new File(filePath,fileName);
                file.transferTo(target);
                return "/uploadUrl/photos/"+fileName;
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败";
            }
        }
        return "上传失败";
    }


}
