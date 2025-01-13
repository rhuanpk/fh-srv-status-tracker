package org.example.statustracker.adapter.mapper;

import org.example.statustracker.adapter.controller.dto.VideoResponseDTO;
import org.example.statustracker.core.domain.Video;

import java.util.List;
import java.util.stream.Collectors;

public class VideoDTOMapper {

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