package org.example.statustracker.domain.service;

import org.example.statustracker.domain.entity.Video;
import org.example.statustracker.domain.repository.VideoRepository;

import java.util.List;

public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> findByUserName(String userName) {
        return videoRepository.findByUserName(userName);
    }
}
