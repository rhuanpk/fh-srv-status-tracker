package org.example.statustracker.domain.repository;

import org.example.statustracker.domain.entity.Video;
import org.example.statustracker.infrastructure.entity.VideoEntity;

import java.util.List;

public interface VideoRepository {

    List<Video> findByUserName(String userName);
}
