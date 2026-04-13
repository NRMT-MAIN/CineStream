package com.nirmit.cinestream.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "yt_videos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    @Id
    private String videoId ;

    private String title ;

    private String description ;

    private String contentType ;

//    @ManyToOne
//    private Course course ;
}
