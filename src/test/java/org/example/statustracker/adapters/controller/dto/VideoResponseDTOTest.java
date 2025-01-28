package org.example.statustracker.adapters.controller.dto;

import org.example.statustracker.domain.Video;
import org.example.statustracker.domain.enums.VideoStatus;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class VideoResponseDTOTest {

    @Spy
    ModelMapper modelMapper;

    @Test
    void constructorShouldInitializeFields() {
        VideoResponseDTO dto = new VideoResponseDTO("123", "https://example.com/video", "user@example.com", VideoStatus.EM_PROCESSAMENTO);

        assertEquals("123", dto.getId());
        assertEquals("https://example.com/video", dto.getUrl());
        assertEquals("user@example.com", dto.getUsername());
        assertEquals(VideoStatus.EM_PROCESSAMENTO, dto.getStatus());
    }

    @Test
    void noArgsConstructorShouldInitializeWithNullValues() {
        VideoResponseDTO dto = new VideoResponseDTO();

        assertNull(dto.getId());
        assertNull(dto.getUrl());
        assertNull(dto.getUsername());
        assertNull(dto.getStatus());
    }

    @Test
    void setIdShouldUpdateId() {
        VideoResponseDTO dto = new VideoResponseDTO();
        dto.setId("456");

        assertEquals("456", dto.getId());
    }

    @Test
    void setUrlShouldUpdateUrl() {
        VideoResponseDTO dto = new VideoResponseDTO();
        dto.setUrl("https://example.com/video2");

        assertEquals("https://example.com/video2", dto.getUrl());
    }

    @Test
    void setUsernameShouldUpdateUsername() {
        VideoResponseDTO dto = new VideoResponseDTO();
        dto.setUsername("newuser@example.com");

        assertEquals("newuser@example.com", dto.getUsername());
    }

    @Test
    void setStatusShouldUpdateStatus() {
        VideoResponseDTO dto = new VideoResponseDTO();
        dto.setStatus(VideoStatus.FINALIZADO);

        assertEquals(VideoStatus.FINALIZADO, dto.getStatus());
    }

    @Test
    void toDTOShouldConvertVideoToDTO() {
        Video video = new Video("123", "https://example.com/video", "user@example.com", VideoStatus.EM_PROCESSAMENTO);
        ModelMapper modelMapper = new ModelMapper();

        VideoResponseDTO dto = VideoResponseDTO.toDTO(modelMapper, video);

        assertEquals("123", dto.getId());
        assertEquals("https://example.com/video", dto.getUrl());
        assertEquals("user@example.com", dto.getUsername());
        assertEquals(VideoStatus.EM_PROCESSAMENTO, dto.getStatus());
    }

    @Test
    void toDTOListShouldConvertListOfVideosToListOfDTOs() {
        Video video1 = new Video("123", "https://example.com/video1", "user1@example.com", VideoStatus.EM_PROCESSAMENTO);
        Video video2 = new Video("124", "https://example.com/video2", "user2@example.com", VideoStatus.FINALIZADO);
        List<Video> videos = List.of(video1, video2);

        List<VideoResponseDTO> dtos = VideoResponseDTO.toDTOList(modelMapper, videos);

        assertEquals(2, dtos.size());
        assertEquals("123", dtos.get(0).getId());
        assertEquals("https://example.com/video1", dtos.get(0).getUrl());
        assertEquals("user1@example.com", dtos.get(0).getUsername());
        assertEquals(VideoStatus.EM_PROCESSAMENTO, dtos.get(0).getStatus());

        assertEquals("124", dtos.get(1).getId());
        assertEquals("https://example.com/video2", dtos.get(1).getUrl());
        assertEquals("user2@example.com", dtos.get(1).getUsername());
        assertEquals(VideoStatus.FINALIZADO, dtos.get(1).getStatus());
    }

}