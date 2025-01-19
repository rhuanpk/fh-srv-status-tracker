package org.example.statustracker.adapters.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.example.statustracker.domain.Video;
import org.example.statustracker.domain.enums.VideoStatus;
import org.modelmapper.ModelMapper;

public class VideoRequestDTO {

    @JsonProperty("url")
    @Schema(example = "https://www.youtube.com/watch?v=123456")
    private String url;

    @JsonProperty("username")
    @Schema(example = "user@email.com")
    private String username;

    @JsonProperty("status")
    @Schema(example = "EM_PROCESSAMENTO")
    private VideoStatus status;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public static Video toDomain(ModelMapper modelMapper, VideoRequestDTO videoRequestDTO) {
        return modelMapper.map(videoRequestDTO, Video.class);
    }
}
