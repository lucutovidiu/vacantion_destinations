package com.vacations.photo;

import com.vacations.photo.service.PhotosService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PhotosController implements PhotosEndpoint {

    private final PhotosService photosService;

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void addPhoto(MultipartFile photo) {
        photosService.addPhoto(photo);
    }

    @Override
    public ResponseEntity getPhotoById(long storageKey) {
        byte[] photoById = photosService.getPhotoById(storageKey);
        return ResponseEntity.ok()
                .contentLength(photoById.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(photoById);
    }
}
