package org.example.statustracker.core.domain.applications.ports;

import org.example.statustracker.adapter.controller.dto.VideoResponseDTO;
import org.example.statustracker.adapter.entity.VideoEntity;
import org.example.statustracker.core.domain.Video;

import java.util.List;

public interface VideoServicePort {

    List<Video> findByUserName(String userName);

    void createVideo(Video video);

    void updateVideo(Video video);


}
