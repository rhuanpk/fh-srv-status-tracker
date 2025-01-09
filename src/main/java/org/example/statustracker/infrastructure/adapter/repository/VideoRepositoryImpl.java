package org.example.statustracker.infrastructure.adapter.repository;

import org.example.statustracker.domain.entity.Video;
import org.example.statustracker.domain.repository.VideoRepository;
import org.example.statustracker.infrastructure.adapter.mapper.VideoMapper;
import org.example.statustracker.infrastructure.entity.VideoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VideoRepositoryImpl implements VideoRepository {
    private final JPAVideoRepository jpaVideoRepository;

    public VideoRepositoryImpl(JPAVideoRepository jpaVideoRepository) {
        this.jpaVideoRepository = jpaVideoRepository;
    }

    @Override
    public List<Video> findByUserName(String userName) {
        List<VideoEntity> videoEntities = jpaVideoRepository.findByUserName(userName);
        return videoEntities.stream()
                .map(VideoMapper::toDomain)
                .toList();
    }
}