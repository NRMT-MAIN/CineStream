package com.nirmit.cinestream.controller;

import com.nirmit.cinestream.entity.Video;
import com.nirmit.cinestream.payload.CustomMessage;
import com.nirmit.cinestream.service.IVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
public class VideoController {

    private final IVideoService videoService ;

    @PostMapping("/save")
    public ResponseEntity<CustomMessage> saveVideo(@RequestParam("file") MultipartFile file ,
                                                   @RequestParam("title") String title ,
                                                   @RequestParam("description") String description) {

        Video video = new Video() ;
        video.setTitle(title);
        video.setDescription(description);
        video.setVideoId(UUID.randomUUID().toString()) ;

        Video saveVideo = videoService.saveVideo(video , file) ;
        if (saveVideo != null) {
            CustomMessage customMessage = CustomMessage.builder()
                    .message("Video saved successfully with id: " + saveVideo.getVideoId())
                    .success(true)
                    .build();
            return ResponseEntity.ok(customMessage);
        } else {
           CustomMessage customMessage = CustomMessage.builder()
                    .message("Failed to save video")
                    .success(false)
                    .build();
            return ResponseEntity.status(500).body(customMessage);
        }
    }
}
