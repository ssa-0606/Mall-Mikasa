package com.imikasa.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Mikasa
 */
public interface UploadService {
    /**
     *  upload img
     * @param file file
     * @return url
     */
    String upload(MultipartFile file);

}
