package com.example.demo;

import software.amazon.awssdk.core.sync.RequestBody;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.file.Paths;


public class S3Uploader {
    public static void main(String[] args) {
        String bucketName = "mydemo12";
        String objectKey = "uploads/sample.txt"; // S3 Key (path inside the bucket)
        String filePath = "E:\\AWS full Notes\\aws.pdf"; // Local file path

        // Create S3 Client
        S3Client s3 = S3Client.builder()
                .region(Region.AP_SOUTH_1) // Change based on your region
                .credentialsProvider(ProfileCredentialsProvider.create("Mahendra"))
                .build();



        // Upload the file
        s3.putObject(PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(objectKey)
                        .build(),
                RequestBody.fromFile(Paths.get(filePath)));

        System.out.println("File uploaded successfully to S3: " + bucketName + "/" + objectKey);
    }
}