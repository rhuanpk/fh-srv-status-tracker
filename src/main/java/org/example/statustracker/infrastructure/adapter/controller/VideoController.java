package org.example.statustracker.infrastructure.adapter.controller;


import org.example.statustracker.application.usecase.GetVideosUseCase;
import org.example.statustracker.application.usecase.dto.VideoResponseDTO;
import org.example.statustracker.infrastructure.exception.handler.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    private final GetVideosUseCase getVideosUseCase;

    public VideoController(GetVideosUseCase getVideosUseCase) {
        this.getVideosUseCase = getVideosUseCase;
    }



    @GetMapping("/{userName}")
    public ResponseEntity<List<VideoResponseDTO>> getVideosByUserName(@PathVariable String userName) {
        List<VideoResponseDTO> videos = getVideosUseCase.execute(userName);
        return ResponseEntity.ok(videos);
    }
}
