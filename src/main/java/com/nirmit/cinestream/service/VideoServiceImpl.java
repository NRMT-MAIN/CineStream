package com.nirmit.cinestream.service;

import com.nirmit.cinestream.entity.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class VideoServiceImpl implements IVideoService{
    @Override
    public Video saveVideo(Video video, MultipartFile file) {
        return null;
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
