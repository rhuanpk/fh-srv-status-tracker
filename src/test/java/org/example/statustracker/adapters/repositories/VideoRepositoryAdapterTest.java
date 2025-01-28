package org.example.statustracker.adapters.repositories;

import org.example.statustracker.adapters.entity.VideoEntity;
import org.example.statustracker.adapters.mapper.VideoEntityMapper;
import org.example.statustracker.domain.Video;
import org.example.statustracker.domain.enums.VideoStatus;
import org.example.statustracker.domain.exception.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest
class VideoRepositoryAdapterTest {

    @Mock
    private VideoRepository videoRepository;

    @Mock
    private VideoEntityMapper videoEntityMapper;

    @InjectMocks
    private VideoRepositoryAdapter videoRepositoryAdapter;

    @Test
    void findByUserName_shouldReturnListOfVideos() {

        String userName = "user1";
        VideoEntity videoEntity = new VideoEntity("1", "https://example.com/video1", "user1", VideoStatus.RECEBIDO);
        Video video = new Video("1", "https://example.com/video1", "user1", VideoStatus.RECEBIDO);

        when(videoRepository.findByUsername(userName)).thenReturn(List.of(videoEntity));
        when(videoEntityMapper.toDomain(videoEntity)).thenReturn(video);


        List<Video> videos = videoRepositoryAdapter.findByUserName(userName);


        assertNotNull(videos);
        assertEquals(1, videos.size());
        assertEquals(video, videos.get(0));
        verify(videoRepository, times(1)).findByUsername(userName);
        verify(videoEntityMapper, times(1)).toDomain(videoEntity);
    }

    @Test
    void create_shouldSaveVideo() {

        Video video = new Video("1", "https://example.com/video1", "user1", VideoStatus.RECEBIDO);
        VideoEntity videoEntity = new VideoEntity("1", "https://example.com/video1", "user1", VideoStatus.RECEBIDO);

        when(videoEntityMapper.toEntity(video)).thenReturn(videoEntity);

        videoRepositoryAdapter.create(video);

        verify(videoEntityMapper, times(1)).toEntity(video);
        verify(videoRepository, times(1)).save(videoEntity);
    }

    @Test
    void updateStatus_shouldUpdateVideoStatus() {
        // Arrange
        Video video = new Video("1", "https://example.com/video1", "user1", VideoStatus.EM_PROCESSAMENTO);
        VideoEntity videoEntity = new VideoEntity("1", "https://example.com/video1", "user1", VideoStatus.RECEBIDO);

        when(videoRepository.findByUrl(video.getUrl())).thenReturn(Optional.of(videoEntity));

        // Act
        videoRepositoryAdapter.updateStatus(video);

        // Assert
        assertEquals(VideoStatus.EM_PROCESSAMENTO, videoEntity.getStatus());
        verify(videoRepository, times(1)).findByUrl(video.getUrl());
        verify(videoRepository, times(1)).save(videoEntity);
    }

    @Test
    void updateStatus_shouldThrowExceptionWhenVideoNotFound() {
        // Arrange
        Video video = new Video("1", "https://example.com/video1", "user1", VideoStatus.EM_PROCESSAMENTO);

        when(videoRepository.findByUrl(video.getUrl())).thenReturn(Optional.empty());

        // Act & Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> videoRepositoryAdapter.updateStatus(video));
        assertEquals("Vídeo não encontrado", exception.getMessage());
        verify(videoRepository, times(1)).findByUrl(video.getUrl());
        verify(videoRepository, never()).save(any());
    }
}