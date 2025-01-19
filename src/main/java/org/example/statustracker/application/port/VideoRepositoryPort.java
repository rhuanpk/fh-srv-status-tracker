package org.example.statustracker.application.port;

import org.example.statustracker.domain.Video;

import java.util.List;

public interface VideoRepositoryPort {

    List<Video> findByUserName(String userName);

    void create(Video video);

    void updateStatus(Video video);
}
