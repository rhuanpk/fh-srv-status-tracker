package org.example.statustracker.adapters.controller.dto;

import org.example.statustracker.domain.Video;
import org.example.statustracker.domain.enums.VideoStatus;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class VideoRequestBasicDTOTest {

    @Spy
    private ModelMapper modelMapper;

    @Test
    void constructorShouldInitializeFields() {
        VideoRequestBasicDTO dto = new VideoRequestBasicDTO("https://example.com/video", VideoStatus.EM_PROCESSAMENTO);

        assertEquals("https://example.com/video", dto.getUrl());
        assertEquals(VideoStatus.EM_PROCESSAMENTO, dto.getStatus());
    }

    @Test
    void noArgsConstructorShouldInitializeWithNullValues() {
        VideoRequestBasicDTO dto = new VideoRequestBasicDTO(null, null);

        assertNull(dto.getUrl());
        assertNull(dto.getStatus());
    }

    @Test
    void setUrlShouldUpdateUrl() {
        VideoRequestBasicDTO dto = new VideoRequestBasicDTO("https://example.com/video", VideoStatus.EM_PROCESSAMENTO);
        dto.setUrl("https://example.com/video2");

        assertEquals("https://example.com/video2", dto.getUrl());
    }

    @Test
    void setStatusShouldUpdateStatus() {
        VideoRequestBasicDTO dto = new VideoRequestBasicDTO("https://example.com/video", VideoStatus.EM_PROCESSAMENTO);
        dto.setStatus(VideoStatus.EM_PROCESSAMENTO);

        assertEquals(VideoStatus.EM_PROCESSAMENTO, dto.getStatus());
    }

    @Test
    void toDomainShouldConvertDTOToVideo() {
        VideoRequestBasicDTO dto = new VideoRequestBasicDTO("https://example.com/video", VideoStatus.EM_PROCESSAMENTO);

        Video video = VideoRequestBasicDTO.toDomain(modelMapper, dto);

        assertEquals("https://example.com/video", video.getUrl());
        assertEquals(VideoStatus.EM_PROCESSAMENTO, video.getStatus());
    }

}