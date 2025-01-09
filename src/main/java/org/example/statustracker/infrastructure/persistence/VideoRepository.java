package org.example.statustracker.infrastructure.persistence;

import org.example.statustracker.infrastructure.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository <VideoEntity, String> {

    List<VideoEntity> findByUserName(String userName);

}
