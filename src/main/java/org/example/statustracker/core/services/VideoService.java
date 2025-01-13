package org.example.statustracker.core.services;

import org.example.statustracker.core.domain.Video;
import org.example.statustracker.core.domain.applications.ports.VideoRepositoryPort;
import org.example.statustracker.core.domain.applications.ports.VideoServicePort;
import org.example.statustracker.adapter.repositories.VideoRepository;

import java.util.List;

public class VideoService implements VideoServicePort {

    private final VideoRepositoryPort videoRepositoryPort;


    public VideoService(VideoRepositoryPort videoRepositoryPort) {
        this.videoRepositoryPort = videoRepositoryPort;
    }

    @Override
    public List<Video> findByUserName(String userName) {
        return videoRepositoryPort.findByUserName(userName);
    }
}
