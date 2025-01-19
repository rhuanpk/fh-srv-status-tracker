package org.example.statustracker.adapters.configuration;

import org.example.statustracker.adapters.mapper.VideoEntityMapper;
import org.example.statustracker.application.port.VideoRepositoryPort;
import org.example.statustracker.application.port.VideoServicePort;
import org.example.statustracker.application.service.VideoService;
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
