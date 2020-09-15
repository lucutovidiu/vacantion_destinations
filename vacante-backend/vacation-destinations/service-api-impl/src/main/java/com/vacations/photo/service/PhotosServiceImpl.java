package com.vacations.photo.service;

import com.vacations.dao.photos.PhotoEntity;
import com.vacations.dao.photos.PhotoRepository;
import com.vacations.photo.pojo.PhotoAttachment;
import com.vacations.photo.util.ImageUtil;
import com.vacations.photo.util.PhotoSize;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PhotosServiceImpl implements PhotosService {

    private final PhotoRepository photoRepository;

    @Override
    @Transactional
    public void addPhoto(MultipartFile photo) {
        try {
            PhotoAttachment photoAttachment = PhotoAttachment.createPhotoAttachment(photo);
            byte[] convertedPhoto = ImageUtil.scalePhoto(photoAttachment, PhotoSize.MEDIUM);
            photoRepository.save(PhotoEntity.createPhotoEntity(convertedPhoto, photo.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("Could not create Photo check type!");
        }
    }

    @Override
    public byte[] getPhotoById(long photoId) {
        return photoRepository.findById(photoId)
                .map(PhotoEntity::getPhoto)
                .orElseThrow(() -> new RuntimeException("Photo not found exception!!"));
    }
}
