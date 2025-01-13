package org.example.statustracker.infrastructure.gateways;

import org.example.statustracker.domain.entity.Video;
import org.example.statustracker.infrastructure.entity.VideoEntity;

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
