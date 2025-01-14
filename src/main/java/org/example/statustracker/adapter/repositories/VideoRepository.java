package org.example.statustracker.adapter.repositories;

import org.example.statustracker.adapter.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface VideoRepository extends JpaRepository <VideoEntity, String> {

    List<VideoEntity> findByUserName(String userName);

}
