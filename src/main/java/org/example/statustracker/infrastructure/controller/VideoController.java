package org.example.statustracker.infrastructure.controller;


import io.swagger.v3.oas.annotations.Parameter;
import org.example.statustracker.application.usecases.GetVideosInteractor;
import org.example.statustracker.domain.entity.Video;
import org.example.statustracker.infrastructure.controller.dto.DtoMapper;
import org.example.statustracker.infrastructure.controller.dto.VideoResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    private final GetVideosInteractor getVideosInteractor;
    private final DtoMapper dtoMapper;

    public VideoController(GetVideosInteractor getVideosInteractor, DtoMapper dtoMapper) {
        this.getVideosInteractor = getVideosInteractor;
        this.dtoMapper = dtoMapper;
    }



    @GetMapping("/{userName}")
    public List<VideoResponseDTO> getVideosByUserName(@Parameter(description = "O nome de usuário para filtrar os vídeos") @PathVariable String userName) {
        List<Video> videos = getVideosInteractor.findByUserName(userName);
        return dtoMapper.toVideoResponseDTOList(videos);
    }
}
