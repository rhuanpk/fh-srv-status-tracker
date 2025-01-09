package org.example.statustracker.application.usecase;

import org.example.statustracker.application.usecase.dto.VideoResponseDTO;
import org.example.statustracker.domain.entity.Video;
import org.example.statustracker.domain.service.VideoService;

import java.util.List;

public class GetVideosUseCase {

    private final VideoService videoService;

    public GetVideosUseCase(VideoService videoService) {
        this.videoService = videoService;
    }

    public List<VideoResponseDTO> execute(String userName) {
        List<Video> videos = videoService.findByUserName(userName);
        return videos.stream().map(video -> new VideoResponseDTO(video.getId(),
                video.getUrl(),
                video.getUserName(),
                video.getUserMail(),
                video.getStatus()))
                .toList();
    }
}
