package org.example.statustracker.adapters.mapper;

import org.example.statustracker.adapters.entity.VideoEntity;
import org.example.statustracker.domain.Video;
import org.example.statustracker.domain.enums.VideoStatus;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class VideoEntityMapperTest {

    @InjectMocks
    VideoEntityMapper videoEntityMapper;

    @Test
    void toDomain_shouldMapVideoEntityToVideo() {

        VideoEntity videoEntity = new VideoEntity("1", "https://example.com/video1", "user1", VideoStatus.RECEBIDO);

        Video video = videoEntityMapper.toDomain(videoEntity);

        assertNotNull(video);
        assertEquals(videoEntity.getId(), video.getId());
        assertEquals(videoEntity.getUrl(), video.getUrl());
        assertEquals(videoEntity.getUsername(), video.getUsername());
        assertEquals(videoEntity.getStatus(), video.getStatus());
    }

    @Test
    void toEntity_shouldMapVideoToVideoEntity() {

        Video video = new Video("2", "https://example.com/video2", "user2", VideoStatus.RECEBIDO);

        VideoEntity videoEntity = videoEntityMapper.toEntity(video);

        assertNotNull(videoEntity);
        assertEquals(video.getId(), videoEntity.getId());
        assertEquals(video.getUrl(), videoEntity.getUrl());
        assertEquals(video.getUsername(), videoEntity.getUsername());
        assertEquals(video.getStatus(), videoEntity.getStatus());
    }
}