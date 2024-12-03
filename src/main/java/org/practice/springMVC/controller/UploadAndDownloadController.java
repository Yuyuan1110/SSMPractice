package org.practice.springMVC.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@RestController
@MultipartConfig
public class UploadAndDownloadController {

//    @GetMapping("/cloud/download")
//    public ResponseEntity<byte[]> testDownload(HttpSession httpSession) throws IOException {
//        ServletContext servletContext = httpSession.getServletContext();
////        String realPath = servletContext.getRealPath("/img/1.jpg");
//        String realPath = servletContext.getRealPath("img");
//        realPath = realPath + File.separator + "1.jpg";
//        InputStream is = new FileInputStream(realPath);
//        byte[] bytes = new byte[is.available()];
//        is.read(bytes);
//
//        MultiValueMap<String, String> headers = new HttpHeaders();
//        headers.add("Content-Disposition", "attachment; filename=1.jpg");
//        HttpStatus statusCode = HttpStatus.OK;
//        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
//        is.close();
//        return responseEntity;
//    }

    @Autowired
    private ResourceLoader resourceLoader;
    @GetMapping("/cloud/download")
    public ResponseEntity<Resource> testDownload() throws IOException {
        Resource file = resourceLoader.getResource("/img/1.jpg");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=1.jpg")
                .body(file);
    }

    @PostMapping("/cloud/upload")
    public String testUpload(@RequestParam("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        return "success";
    }
}
