package org.example.statustracker.adapter.repositories;

import org.example.statustracker.adapter.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends JpaRepository <VideoEntity, String> {

    List<VideoEntity> findByUsername(String userName);

    Optional<VideoEntity> findByUrl(String url);
}
