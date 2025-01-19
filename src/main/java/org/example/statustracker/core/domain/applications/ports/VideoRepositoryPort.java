package org.example.statustracker.core.domain.applications.ports;

import org.example.statustracker.core.domain.Video;

import java.util.List;

public interface VideoRepositoryPort {

    List<Video> findByUserName(String userName);

    void create(Video video);

    void updateStatus(Video video);
}
