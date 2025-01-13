package org.example.statustracker.main;

import org.example.statustracker.application.gateways.VideoGateway;
import org.example.statustracker.application.usecases.GetVideosInteractor;
import org.example.statustracker.infrastructure.controller.dto.DtoMapper;
import org.example.statustracker.infrastructure.gateways.VideoEntityMapper;
import org.example.statustracker.infrastructure.gateways.VideoRepositoryGateway;
import org.example.statustracker.infrastructure.persistence.VideoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VideoConfig {

    @Bean
    GetVideosInteractor getVideosInteractor(VideoGateway videoGateway) {
        return new GetVideosInteractor(videoGateway);
    }

    @Bean
    VideoGateway videoGateway(VideoRepository videoRepository, VideoEntityMapper videoEntityMapper) {
        return new VideoRepositoryGateway(videoRepository, videoEntityMapper);
    }

    @Bean
    VideoEntityMapper videoEntityMapper() {
        return new VideoEntityMapper();
    }

    @Bean
    DtoMapper dtoMapper() {
        return new DtoMapper();
    }
}
