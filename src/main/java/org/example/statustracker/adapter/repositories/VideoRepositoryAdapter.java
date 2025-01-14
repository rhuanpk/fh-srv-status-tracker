package org.example.statustracker.adapter.repositories;

import org.example.statustracker.adapter.entity.VideoEntity;
import org.example.statustracker.adapter.mapper.VideoEntityMapper;
import org.example.statustracker.core.domain.Video;
import org.example.statustracker.core.domain.applications.ports.VideoRepositoryPort;
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
}
