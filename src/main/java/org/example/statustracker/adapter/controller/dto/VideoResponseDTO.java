package org.example.statustracker.adapter.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.example.statustracker.core.domain.enums.VideoStatus;


@Data
public class VideoResponseDTO {

    @JsonProperty("id")
    @Schema(example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @JsonProperty("url")
    @Schema(example = "https://www.youtube.com/watch?v=123456")
    private String url;

    @JsonProperty("userName")
    @Schema(example = "user123")
    private String userName;

    @JsonProperty("userMail")
    @Schema(example = "user@email.com")
    private String userMail;

    @JsonProperty("status")
    @Schema(example = "EM_PROCESSAMENTO")
    private VideoStatus status;

    public VideoResponseDTO(String id, String url, String userName, String userMail, VideoStatus status) {
        this.id = id;
        this.url = url;
        this.userName = userName;
        this.userMail = userMail;
        this.status = status;
    }
}
