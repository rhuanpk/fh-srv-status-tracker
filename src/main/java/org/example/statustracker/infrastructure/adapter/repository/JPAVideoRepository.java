package org.example.statustracker.infrastructure.adapter.repository;


import org.example.statustracker.infrastructure.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JPAVideoRepository extends JpaRepository<VideoEntity, UUID> {

    List<VideoEntity> findByUserName(String userName);

}
