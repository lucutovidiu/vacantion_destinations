package com.vacations.photo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface PhotosService {

    void addPhoto(MultipartFile photo);

    byte[] getPhotoById(long storageKey);
}
