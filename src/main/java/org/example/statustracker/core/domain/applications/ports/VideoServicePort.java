package org.example.statustracker.core.domain.applications.ports;

import org.example.statustracker.core.domain.Video;

import java.util.List;

public interface VideoServicePort {

    List<Video> findByUserName(String userName);
}
