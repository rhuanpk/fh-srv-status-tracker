package org.example.statustracker.adapter.configuration;

import org.example.statustracker.adapter.mapper.VideoEntityMapper;
import org.example.statustracker.core.domain.applications.ports.VideoRepositoryPort;
import org.example.statustracker.core.domain.applications.ports.VideoServicePort;
import org.example.statustracker.core.services.VideoService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public VideoServicePort videoServicePortImpl(VideoRepositoryPort videoRepositoryPort) {
        return new VideoService(videoRepositoryPort);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public VideoEntityMapper videoEntityMapper() {
        return new VideoEntityMapper();
    }
}
