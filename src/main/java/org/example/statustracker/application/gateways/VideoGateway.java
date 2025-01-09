package org.example.statustracker.application.gateways;

import org.example.statustracker.domain.entity.Video;

import java.util.List;

public interface VideoGateway {

    List<Video> findByUserName(String userName);
}
