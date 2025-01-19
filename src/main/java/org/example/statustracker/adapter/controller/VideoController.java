package org.example.statustracker.adapter.controller;


import io.swagger.v3.oas.annotations.Parameter;
import org.example.statustracker.adapter.controller.dto.VideoRequestBasicDTO;
import org.example.statustracker.adapter.controller.dto.VideoRequestDTO;
import org.example.statustracker.adapter.controller.dto.VideoResponseDTO;
import org.example.statustracker.core.domain.Video;
import org.example.statustracker.core.domain.applications.ports.VideoServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {


    private final VideoServicePort videoServicePort;
    private final ModelMapper modelMapper;

    public VideoController(VideoServicePort videoServicePort, ModelMapper modelMapper) {
        this.videoServicePort = videoServicePort;
        this.modelMapper = modelMapper;
    }



    @GetMapping("/{userName}")
    public ResponseEntity<List<VideoResponseDTO>> getVideosByUserName(@Parameter(description = "O email para filtragem os vídeos") @PathVariable String userName) {
        List<Video> videos = videoServicePort.findByUserName(userName);
        List<VideoResponseDTO> list = VideoResponseDTO.toDTOList(modelMapper, videos);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createVideoStatus(@RequestBody VideoRequestDTO videoRequestDTO) {
        Video video = VideoRequestDTO.toDomain(modelMapper, videoRequestDTO);
        videoServicePort.createStatus(video);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateStatus(@RequestBody VideoRequestBasicDTO videoRequestBasicDTO) {
        Video video = VideoRequestBasicDTO.toDomain(modelMapper, videoRequestBasicDTO);
        videoServicePort.updateStatus(video);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
