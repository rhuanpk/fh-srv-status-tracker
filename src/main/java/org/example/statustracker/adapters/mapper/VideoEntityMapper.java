package org.example.statustracker.adapters.mapper;

import org.example.statustracker.domain.Video;
import org.example.statustracker.adapters.entity.VideoEntity;

public class VideoEntityMapper {

    public Video toDomain(VideoEntity videoEntity) {
        return new Video(videoEntity.getId(),
                videoEntity.getUrl(),
                videoEntity.getUsername(),
                videoEntity.getStatus());
    }

    public VideoEntity toEntity(Video video) {
        return new VideoEntity(video.getId(),
                video.getUrl(),
                video.getUsername(),
                video.getStatus());
    }
}
