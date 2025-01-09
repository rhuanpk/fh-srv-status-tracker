package org.example.statustracker.application.usecase;

import org.example.statustracker.application.usecase.dto.VideoResponseDTO;
import org.example.statustracker.domain.entity.Video;
import org.example.statustracker.domain.service.VideoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GetVideosUseCase {

    private final VideoService videoService;

    public GetVideosUseCase(VideoService videoService) {
        this.videoService = videoService;
    }

    public List<VideoResponseDTO> execute(String userName) {
        List<Video> videos = videoService.findByUserName(userName);
        return videos.stream().map(video -> VideoResponseDTO.builder()
                .id(video.getId())
                .url(video.getUrl())
                .userName(video.getUserName())
                .userMail(video.getUserMail())
                .status(video.getStatus())
                .build()).collect(Collectors.toList());
    }
}
