package com.springRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springRest.helper.FileuploaderHelp;

@RestController
public class FIleUploadController {

    @Autowired
    private FileuploaderHelp fileuploaderHelp;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        try {

            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File is empty");
            }

            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("JPEG files are only allowed");
            }

            // file uploading

            boolean r = this.fileuploaderHelp.uploadFile(file);

            if (r) {
                // return ResponseEntity.status(HttpStatus.ACCEPTED).body("File Successfuly uploaded");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());

            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong,Try Again!!");

        }
        return ResponseEntity.ok("Working");
    }
}
