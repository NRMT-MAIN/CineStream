package com.nirmit.cinestream.service;

import com.nirmit.cinestream.entity.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IVideoService {
    Video saveVideo(Video video, MultipartFile file) ;
    Video getVideoById(String id) ;
    Video getVideoByTitle(String title) ;
    void deleteVideoById(String id) ;
    void deleteVideoByTitle(String title) ;
    Video updateVideo(String id, Video video, MultipartFile file) ;
    List<Video> getAllVideos() ;
}
