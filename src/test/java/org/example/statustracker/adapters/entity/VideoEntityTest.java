package org.example.statustracker.adapters.entity;

import org.example.statustracker.domain.enums.VideoStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class VideoEntityTest {

    @Test
    void constructorShouldInitializeFields() {
        VideoEntity videoEntity = new VideoEntity(
                "1",
                "https://example.com/video1",
                "user1",
                VideoStatus.RECEBIDO
        );

        assertEquals("1", videoEntity.getId());
        assertEquals("https://example.com/video1", videoEntity.getUrl());
        assertEquals("user1", videoEntity.getUsername());
        assertEquals(VideoStatus.RECEBIDO, videoEntity.getStatus());
    }

    @Test
    void noArgsConstructorShouldInitializeWithNullValues() {
        VideoEntity videoEntity = new VideoEntity();

        assertNull(videoEntity.getId());
        assertNull(videoEntity.getUrl());
        assertNull(videoEntity.getUsername());
        assertNull(videoEntity.getStatus());
    }

    @Test
    void setIdShouldUpdateId() {
        VideoEntity videoEntity = new VideoEntity();
        String id = "1";

        videoEntity.setId(id);

        assertEquals(id, videoEntity.getId());
    }

    @Test
    void setUrlShouldUpdateUrl() {
        VideoEntity videoEntity = new VideoEntity();
        String url = "https://example.com/video1";

        videoEntity.setUrl(url);

        assertEquals(url, videoEntity.getUrl());
    }

    @Test
    void setUsernameShouldUpdateUsername() {
        VideoEntity videoEntity = new VideoEntity();
        String username = "user1";

        videoEntity.setUsername(username);

        assertEquals(username, videoEntity.getUsername());
    }

    @Test
    void setStatusShouldUpdateStatus() {
        VideoEntity videoEntity = new VideoEntity();
        VideoStatus status = VideoStatus.EM_PROCESSAMENTO;

        videoEntity.setStatus(status);

        assertEquals(status, videoEntity.getStatus());
    }
}