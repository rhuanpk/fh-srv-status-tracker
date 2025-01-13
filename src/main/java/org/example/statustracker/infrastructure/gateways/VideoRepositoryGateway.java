package org.example.statustracker.infrastructure.gateways;

import org.example.statustracker.application.gateways.VideoGateway;
import org.example.statustracker.domain.entity.Video;
import org.example.statustracker.infrastructure.entity.VideoEntity;
import org.example.statustracker.infrastructure.persistence.VideoRepository;

import java.util.ArrayList;
import java.util.List;

public class VideoRepositoryGateway implements VideoGateway  {

    private final VideoRepository videoRepository;
    private final VideoEntityMapper videoEntityMapper;

    public VideoRepositoryGateway(VideoRepository videoRepository, VideoEntityMapper videoEntityMapper) {
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
