package org.example.statustracker.adapter.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.example.statustracker.core.domain.Video;
import org.example.statustracker.core.domain.enums.VideoStatus;
import org.modelmapper.ModelMapper;

public class VideoRequestBasicDTO {

    @JsonProperty("url")
    @Schema(example = "https://www.youtube.com/watch?v=123456")
    private String url;

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

    public VideoRequestBasicDTO(String url, VideoStatus status) {
        this.url = url;
        this.status = status;
    }

    public static Video toDomain(ModelMapper modelMapper, VideoRequestBasicDTO videoRequestBasicDTO) {
        return modelMapper.map(videoRequestBasicDTO, Video.class);
    }
}
