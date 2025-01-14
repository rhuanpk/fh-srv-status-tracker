package org.example.statustracker.adapter.controller;


import io.swagger.v3.oas.annotations.Parameter;
import org.example.statustracker.adapter.controller.dto.VideoRequestDTO;
import org.example.statustracker.adapter.controller.dto.VideoResponseDTO;
import org.example.statustracker.adapter.mapper.VideoRequestDTOMapper;
import org.example.statustracker.adapter.mapper.VideoResponseDTOMapper;
import org.example.statustracker.core.domain.Video;
import org.example.statustracker.core.domain.applications.ports.VideoServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {


    private final VideoServicePort videoServicePort;
    private final VideoRequestDTOMapper videoRequestDTOMapper;
    private final VideoResponseDTOMapper videoResponseDTOMapper;

    public VideoController(VideoServicePort videoServicePort, VideoRequestDTOMapper videoRequestDTOMapper, VideoResponseDTOMapper videoResponseDTOMapper) {
        this.videoServicePort = videoServicePort;
        this.videoRequestDTOMapper = videoRequestDTOMapper;
        this.videoResponseDTOMapper = videoResponseDTOMapper;
    }



    @GetMapping("/{userName}")
    public ResponseEntity<List<VideoResponseDTO>> getVideosByUserName(@Parameter(description = "O nome de usuário para filtrar os vídeos") @PathVariable String userName) {
        List<Video> videos = videoServicePort.findByUserName(userName);
        List<VideoResponseDTO> videoResponseDTOList = videoResponseDTOMapper.toVideoResponseDTOList(videos);
        return new ResponseEntity<>(videoResponseDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createVideoStatus(@RequestBody VideoRequestDTO videoRequestDTO) {
        Video video = videoRequestDTOMapper.toDomainCreate(videoRequestDTO);
        videoServicePort.createVideo(video);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateStatus(@RequestBody VideoRequestDTO videoRequestDTO) {
        Video video = videoRequestDTOMapper.toDomainUpdate(videoRequestDTO);
        videoServicePort.updateVideo(video);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
