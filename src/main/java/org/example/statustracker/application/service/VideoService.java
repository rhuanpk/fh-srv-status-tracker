package org.example.statustracker.application.service;

import org.example.statustracker.domain.Video;
import org.example.statustracker.application.port.VideoRepositoryPort;
import org.example.statustracker.application.port.VideoServicePort;
import org.example.statustracker.domain.exception.BusinessException;

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

    @Override
    public void createStatus(Video video) {
        videoRepositoryPort.create(video);
    }

    @Override
    public void updateStatus(Video video) {
        if(video.getUrl() == null) {
            throw new BusinessException("URL é obrigatória");
        }

        if(video.getStatus() == null) {
            throw new BusinessException("Status é obrigatório");
        }
        videoRepositoryPort.updateStatus(video);
    }
}
