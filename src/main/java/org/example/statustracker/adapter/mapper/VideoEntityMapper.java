package org.example.statustracker.adapter.mapper;

import org.example.statustracker.core.domain.Video;
import org.example.statustracker.adapter.entity.VideoEntity;

public class VideoEntityMapper {

    public Video toDomain(VideoEntity videoEntity) {
        return new Video(videoEntity.getId(),
                videoEntity.getUrl(),
                videoEntity.getUserName(),
                videoEntity.getUserMail(),
                videoEntity.getStatus());
    }

    public VideoEntity toEntity(Video video) {
        return new VideoEntity(video.getId(),
                video.getUrl(),
                video.getUserName(),
                video.getUserMail(),
                video.getStatus());
    }
}
