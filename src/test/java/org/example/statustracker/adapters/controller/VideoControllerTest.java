package org.example.statustracker.adapters.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.statustracker.adapters.controller.dto.VideoRequestBasicDTO;
import org.example.statustracker.application.port.VideoServicePort;
import org.example.statustracker.domain.Video;
import org.example.statustracker.domain.enums.VideoStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;


import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
class VideoControllerTest {

    @MockBean
    private VideoServicePort videoServicePort;

    @Spy
    private ModelMapper modelMapper;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    List<Video> videos;


    @Test
    void getVideosByUserName() throws Exception {
        when(videoServicePort.findByUserName("user")).thenReturn(videos);

        mockMvc.perform(get("/videos/{userName}" , videos.get(0).getUsername()))
                .andExpect(status().isOk());
    }

    @Test
    void createVideoStatus() throws Exception {

        Video video = new Video(UUID.randomUUID().toString(), "user", "video1", VideoStatus.RECEBIDO);

        mockMvc.perform(post("/videos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(video)))
                .andExpect(status().isCreated());
    }

    @Test
    void updateStatus() throws Exception {

        VideoRequestBasicDTO videoRequestBasicDTO = new VideoRequestBasicDTO("https://example.com/3f6a9c71-d5b4-4a2f-9e2b-831e4f0c12ef",  VideoStatus.RECEBIDO);

        doNothing().when(videoServicePort).updateStatus(any(Video.class));

        mockMvc.perform(put("/videos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(videoRequestBasicDTO)))
                .andExpect(status().isNoContent());
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        VideoController videoController = new VideoController(videoServicePort, modelMapper);
        this.mockMvc = MockMvcBuilders.standaloneSetup(videoController).build();

        videos = List.of(
                new Video(UUID.randomUUID().toString(), "https://example.com/3f6a9c71-d5b4-4a2f-9e2b-831e4f0c12ef", "user1", VideoStatus.RECEBIDO),
                new Video(UUID.randomUUID().toString(), "https://example.com/3f6a9c71-d5b4-4a2f-9e2b-831e4f0c12ef", "user1", VideoStatus.RECEBIDO),
                new Video(UUID.randomUUID().toString(), "https://example.com/3f6a9c71-d5b4-4a2f-9e2b-831e4f0c12ef", "user1", VideoStatus.RECEBIDO)
        );


    }
}