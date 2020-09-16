package com.vacations.photo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/attachments")
public interface PhotosEndpoint {

    @ResponseStatus(code = HttpStatus.CREATED)
    @ApiOperation(value = "Add new photo")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Input values incorect!")})
    @PostMapping
    void addPhoto(@RequestParam("file") MultipartFile photo);

    @ApiOperation(value = "Get photo")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Input values incorect!")})
    @GetMapping("/photo/{storageKey}")
    ResponseEntity getPhotoById(@PathVariable("storageKey") long storageKey);
}
