package com.vacations.photo.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Getter
@Setter
@NoArgsConstructor
public class PhotoAttachment {
    private byte[] content;
    private String filename;
    private String name;
    private String contentType;

    public static PhotoAttachment createPhotoAttachment(MultipartFile photo) throws IOException {
        PhotoAttachment attachment = new PhotoAttachment();
        attachment.setContent(photo.getBytes());
        attachment.setContentType(photo.getContentType());
        attachment.setFilename(photo.getOriginalFilename());
        attachment.setName(photo.getName());
        return attachment;
    }
}
