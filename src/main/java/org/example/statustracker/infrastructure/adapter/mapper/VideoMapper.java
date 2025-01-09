package org.example.statustracker.infrastructure.adapter.mapper;

import org.example.statustracker.domain.entity.Video;
import org.example.statustracker.infrastructure.entity.VideoEntity;

public class VideoMapper {

    public static Video toDomain(VideoEntity videoEntity) {
        return new Video(videoEntity.getId(),
                videoEntity.getUrl(),
                videoEntity.getUserName(),
                videoEntity.getUserMail(),
                videoEntity.getStatus());
    }

    public static VideoEntity toEntity(Video video) {
        return new VideoEntity(video.getId(),
                video.getUrl(),
                video.getUserName(),
                video.getUserMail(),
                video.getStatus());
    }
}
