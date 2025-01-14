package org.example.statustracker.adapter.controller;


import io.swagger.v3.oas.annotations.Parameter;
import org.example.statustracker.adapter.controller.dto.VideoResponseDTO;
import org.example.statustracker.adapter.mapper.VideoDTOMapper;
import org.example.statustracker.core.domain.Video;
import org.example.statustracker.core.domain.applications.ports.VideoServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {


    private final VideoServicePort videoServicePort;
    private final VideoDTOMapper videoDTOMapper;

    public VideoController(VideoServicePort videoServicePort, VideoDTOMapper videoDTOMapper) {
        this.videoServicePort = videoServicePort;
        this.videoDTOMapper = videoDTOMapper;
    }



    @GetMapping("/{userName}")
    public ResponseEntity<List<VideoResponseDTO>> getVideosByUserName(@Parameter(description = "O nome de usuário para filtrar os vídeos") @PathVariable String userName) {
        List<Video> videos = videoServicePort.findByUserName(userName);
        List<VideoResponseDTO> videoResponseDTOList = videoDTOMapper.toVideoResponseDTOList(videos);
        return new ResponseEntity<>(videoResponseDTOList, HttpStatus.OK);
    }
}
