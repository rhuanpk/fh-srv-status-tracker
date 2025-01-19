package org.example.statustracker.adapters.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.example.statustracker.domain.Video;
import org.example.statustracker.domain.enums.VideoStatus;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class VideoResponseDTO {

    @JsonProperty("id")
    @Schema(example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @JsonProperty("url")
    @Schema(example = "https://www.youtube.com/watch?v=123456")
    private String url;

    @JsonProperty("username")
    @Schema(example = "user@email.com")
    private String username;

    @JsonProperty("status")
    @Schema(example = "EM_PROCESSAMENTO")
    private VideoStatus status;

    public VideoResponseDTO(String id, String url, String username, VideoStatus status) {
        this.id = id;
        this.url = url;
        this.username = username;
        this.status = status;
    }

    public VideoResponseDTO(){
    }

    public VideoStatus getStatus() {
        return status;
    }

    public void setStatus(VideoStatus status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static VideoResponseDTO toDTO(ModelMapper modelMapper, Video video){
       return modelMapper.map(video, VideoResponseDTO.class);
    }

    public static List<VideoResponseDTO> toDTOList(ModelMapper modelMapper, List<Video> videos){
        return videos.stream().map(video -> toDTO(modelMapper, video)).collect(Collectors.toList());
    }
}
