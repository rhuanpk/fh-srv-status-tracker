package org.example.statustracker.adapter.configuration;

import org.example.statustracker.adapter.mapper.VideoEntityMapper;
import org.example.statustracker.adapter.mapper.VideoRequestDTOMapper;
import org.example.statustracker.adapter.mapper.VideoResponseDTOMapper;
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
    public VideoRequestDTOMapper videoRequestDTOMapper() {
        return new VideoRequestDTOMapper();
    }

    @Bean
    public VideoResponseDTOMapper videoResponseDTOMapper() {
        return new VideoResponseDTOMapper();
    }

    @Bean
    public VideoEntityMapper videoEntityMapper() {
        return new VideoEntityMapper();
    }
}
