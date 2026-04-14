package com.nirmit.cinestream.service;

import com.nirmit.cinestream.entity.Video;
import com.nirmit.cinestream.repository.VideoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements IVideoService{

    @Value("${video.storage.path}")
    private String videoStoragePath ;

    private final VideoRepository videoRepo ;

    @PostConstruct
    public void init() {
        File folder = new File(videoStoragePath) ;
        if (!folder.exists()) {
            folder.mkdirs();
            System.out.println("Video storage folder created at: " + videoStoragePath);
        } else {
            System.out.println("Video storage folder already exists at: " + videoStoragePath);
        }

    }

    @Override
    public Video saveVideo(Video video, MultipartFile file) {
        try {
            String filename = file.getOriginalFilename() ;
            String contentType = file.getContentType() ;
            InputStream inputStream = file.getInputStream() ;

            //folder path : create
            String cleanFileName = StringUtils.cleanPath(filename) ;
            String cleanFolder = StringUtils.cleanPath(videoStoragePath) ;

            Path path = Paths.get(cleanFolder , cleanFileName) ;
            System.out.println("Saving video to path: " + path.toString());

            //copy file to the folder
            Files.copy(inputStream , path , StandardCopyOption.REPLACE_EXISTING) ;

            //video meta data save to db
            video.setContentType(contentType);
            video.setVideoPath(path.toString());

            return videoRepo.save(video) ;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }

    @Override
    public Video getVideoById(String id) {
        return null;
    }

    @Override
    public Video getVideoByTitle(String title) {
        return null;
    }

    @Override
    public void deleteVideoById(String id) {

    }

    @Override
    public void deleteVideoByTitle(String title) {

    }

    @Override
    public Video updateVideo(String id, Video video, MultipartFile file) {
        return null;
    }

    @Override
    public List<Video> getAllVideos() {
        return List.of();
    }
}
