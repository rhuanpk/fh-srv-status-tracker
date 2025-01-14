package org.example.statustracker.adapter.mapper;

import org.example.statustracker.adapter.controller.dto.VideoRequestDTO;
import org.example.statustracker.core.domain.Video;

import java.util.UUID;

public class VideoRequestDTOMapper {

    public Video toDomainCreate(VideoRequestDTO videoRequestDTO) {
        return new Video(UUID.randomUUID().toString(),
                videoRequestDTO.getUrl(),
                videoRequestDTO.getUserName(),
                videoRequestDTO.getUserMail(),
                videoRequestDTO.getStatus());
    }

    public Video toDomainUpdate(VideoRequestDTO videoRequestDTO) {
        return new Video(videoRequestDTO.getId(),
                videoRequestDTO.getUrl(),
                videoRequestDTO.getUserName(),
                videoRequestDTO.getUserMail(),
                videoRequestDTO.getStatus());
    }
}
