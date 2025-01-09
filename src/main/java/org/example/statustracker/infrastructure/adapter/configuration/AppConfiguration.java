package org.example.statustracker.infrastructure.adapter.configuration;

import org.example.statustracker.application.usecase.GetVideosUseCase;
import org.example.statustracker.domain.repository.VideoRepository;
import org.example.statustracker.domain.service.VideoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public GetVideosUseCase getVideosUseCase(VideoService videoService) {
        return new GetVideosUseCase(videoService);
    }

    @Bean
    public VideoService videoService(VideoRepository videoRepository) {
        return new VideoService(videoRepository);
    }
}
