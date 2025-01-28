package org.example.statustracker.domain;

import org.example.statustracker.domain.enums.VideoStatus;
import org.example.statustracker.domain.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class VideoTest {

    @Test
    void constructorShouldInitializeFields() {
        Video video = new Video("1", "https://example.com/video1", "user1", VideoStatus.RECEBIDO);
        assertEquals("1", video.getId());
        assertEquals("https://example.com/video1", video.getUrl());
        assertEquals("user1", video.getUsername());
        assertEquals(VideoStatus.RECEBIDO, video.getStatus());
    }

    @Test
    void setUsername_shouldUpdateUsername() {
        Video video = new Video();
        String username = "user1";
        video.setUsername(username);
        assertEquals(username, video.getUsername());
    }

    @Test
    void setUsername_shouldThrowExceptionWhenUsernameIsNull() {
        Video video = new Video();
        BusinessException exception = assertThrows(BusinessException.class, () -> video.setUsername(null));
        assertEquals("Usuário não pode ser nulo", exception.getMessage());
    }

    @Test
    void setUsername_shouldThrowExceptionWhenUsernameIsBlank() {
        Video video = new Video();
        BusinessException exception = assertThrows(BusinessException.class, () -> video.setUsername(" "));
        assertEquals("Usuário não pode ser nulo", exception.getMessage());
    }

    @Test
    void setStatus_shouldUpdateStatus() {
        Video video = new Video();
        VideoStatus status = VideoStatus.EM_PROCESSAMENTO;
        video.setStatus(status);
        assertEquals(status, video.getStatus());
    }

    @Test
    void setStatus_shouldThrowExceptionWhenStatusIsNull() {
        Video video = new Video();
        BusinessException exception = assertThrows(BusinessException.class, () -> video.setStatus(null));
        assertEquals("Status não pode ser nulo", exception.getMessage());
    }

}