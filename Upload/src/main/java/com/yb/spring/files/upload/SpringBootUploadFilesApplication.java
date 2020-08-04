package com.yb.spring.files.upload;

import javax.annotation.Resource;

import com.yb.spring.files.upload.service.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringBootUploadFilesApplication implements CommandLineRunner {
  @Resource
  FilesStorageService storageService;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootUploadFilesApplication.class, args);

  }


  @Override
  public void run(String... arg) throws Exception {
//    storageService.deleteAll();
//    storageService.init();
  }

}

