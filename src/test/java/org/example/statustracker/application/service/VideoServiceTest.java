package org.example.statustracker.application.service;

import org.example.statustracker.application.port.VideoRepositoryPort;
import org.example.statustracker.domain.Video;
import org.example.statustracker.domain.enums.VideoStatus;
import org.example.statustracker.domain.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ActiveProfiles("test")
@SpringBootTest
class VideoServiceTest {

    @Mock
    private VideoRepositoryPort videoRepositoryPort;

    @InjectMocks
    private VideoService videoService;

    @Test
    void findByUserName_shouldReturnListOfVideos() {
        String userName = "user1";
        List<Video> expectedVideos = List.of(new Video("1", "https://example.com/video1", "user1", VideoStatus.RECEBIDO));
        when(videoRepositoryPort.findByUserName(userName)).thenReturn(expectedVideos);

        List<Video> actualVideos = videoService.findByUserName(userName);

        assertNotNull(actualVideos);
        assertEquals(expectedVideos.size(), actualVideos.size());
        assertEquals(expectedVideos.get(0), actualVideos.get(0));
        verify(videoRepositoryPort, times(1)).findByUserName(userName);
    }

    @Test
    void createStatus_shouldCallRepository() {

        Video video = new Video("1", "https://example.com/video1", "user1", VideoStatus.RECEBIDO);

        videoService.createStatus(video);


        verify(videoRepositoryPort, times(1)).create(video);
    }

    @Test
    void updateStatus_shouldCallRepositoryWhenValidVideo() {

        Video video = new Video("1", "https://example.com/video1", "user1", VideoStatus.EM_PROCESSAMENTO);


        videoService.updateStatus(video);


        verify(videoRepositoryPort, times(1)).updateStatus(video);
    }

    @Test
    void updateStatus_shouldThrowExceptionWhenUrlIsNull() {

        Video video = new Video("1", null, "user1", VideoStatus.EM_PROCESSAMENTO);


        BusinessException exception = assertThrows(BusinessException.class, () -> videoService.updateStatus(video));
        assertEquals("URL é obrigatória", exception.getMessage());
        verify(videoRepositoryPort, never()).updateStatus(any());
    }

    @Test
    void updateStatus_shouldThrowExceptionWhenStatusIsNull() {

        Video video = new Video("1", "https://example.com/video1", "user1", null);


        BusinessException exception = assertThrows(BusinessException.class, () -> videoService.updateStatus(video));
        assertEquals("Status é obrigatório", exception.getMessage());
        verify(videoRepositoryPort, never()).updateStatus(any());
    }
}