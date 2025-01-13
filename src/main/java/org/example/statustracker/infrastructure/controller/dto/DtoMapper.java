package org.example.statustracker.infrastructure.controller.dto;

import org.example.statustracker.domain.entity.Video;

import java.util.List;
import java.util.stream.Collectors;

public class DtoMapper {

    public VideoResponseDTO toVideoResponseDTO(Video video) {
        return new VideoResponseDTO(video.getId(),
                video.getUrl(),
                video.getUserName(),
                video.getUserMail(),
                video.getStatus());
    }

    public List<VideoResponseDTO> toVideoResponseDTOList(List<Video> videos) {
        return videos.stream().map(this::toVideoResponseDTO).collect(Collectors.toList());
    }
}
