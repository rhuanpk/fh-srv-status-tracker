package org.example.statustracker.adapters.repositories;

import org.example.statustracker.adapters.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends JpaRepository <VideoEntity, String> {

    List<VideoEntity> findByUsername(String userName);

    Optional<VideoEntity> findByUrl(String url);
}
