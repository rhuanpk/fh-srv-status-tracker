package org.example.statustracker.application.usecases;

import org.example.statustracker.application.gateways.VideoGateway;
import org.example.statustracker.domain.entity.Video;
import org.springframework.stereotype.Component;

import java.util.List;

public class GetVideosInteractor implements VideoGateway {

    private VideoGateway videoGateway;

    public GetVideosInteractor(VideoGateway videoGateway) {
        this.videoGateway = videoGateway;
    }

    @Override
    public List<Video> findByUserName(String userName) {
        return videoGateway.findByUserName(userName);
    }
}
