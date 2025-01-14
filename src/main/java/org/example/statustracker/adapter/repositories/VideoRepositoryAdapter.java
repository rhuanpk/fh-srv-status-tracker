package org.example.statustracker.adapter.repositories;

import org.example.statustracker.adapter.entity.VideoEntity;
import org.example.statustracker.adapter.mapper.VideoEntityMapper;
import org.example.statustracker.core.domain.Video;
import org.example.statustracker.core.domain.applications.ports.VideoRepositoryPort;
import org.example.statustracker.core.services.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VideoRepositoryAdapter implements VideoRepositoryPort {

    private final VideoRepository videoRepository;
    private final VideoEntityMapper videoEntityMapper;

    public VideoRepositoryAdapter(VideoRepository videoRepository, VideoEntityMapper videoEntityMapper) {
        this.videoRepository = videoRepository;
        this.videoEntityMapper = videoEntityMapper;
    }

    @Override
    public List<Video> findByUserName(String userName) {
        List<VideoEntity> videosEntities = videoRepository.findByUserName(userName);
        List<Video> videos = new ArrayList<>();
        for(VideoEntity videoEntity : videosEntities) {
            videos.add(videoEntityMapper.toDomain(videoEntity));
        }
        return videos;
    }

    @Override
    public void save(Video video) {
        VideoEntity videoEntity = videoEntityMapper.toEntity(video);
        videoRepository.save(videoEntity);
    }

    @Override
    public void updateVideo(Video video) {
        VideoEntity videoEntity = videoRepository.findByUrl(video.getUrl());

        if(videoEntity == null) {
            throw new EntityNotFoundException("Vídeo não encontrado");
        }

        videoEntity.setStatus(video.getStatus());
        videoRepository.save(videoEntity);
    }
}
