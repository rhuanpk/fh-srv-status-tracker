package org.example.statustracker.application.port;

import org.example.statustracker.domain.Video;

import java.util.List;

public interface VideoServicePort {

    List<Video> findByUserName(String userName);

    void createStatus(Video video);

    void updateStatus(Video video);


}
