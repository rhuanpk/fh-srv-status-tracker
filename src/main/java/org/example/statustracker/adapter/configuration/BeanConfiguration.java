package org.example.statustracker.adapter.configuration;

import org.example.statustracker.adapter.mapper.VideoDTOMapper;
import org.example.statustracker.adapter.mapper.VideoEntityMapper;
import org.example.statustracker.core.domain.applications.ports.VideoRepositoryPort;
import org.example.statustracker.core.domain.applications.ports.VideoServicePort;
import org.example.statustracker.core.services.VideoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public VideoServicePort videoServicePortImpl(VideoRepositoryPort videoRepositoryPort) {
        return new VideoService(videoRepositoryPort);
    }

    @Bean
    public VideoDTOMapper videoDTOMapper() {
        return new VideoDTOMapper();
    }

    @Bean
    public VideoEntityMapper videoEntityMapper() {
        return new VideoEntityMapper();
    }
}
