package org.example.statustracker.application.usecase.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.statustracker.domain.entity.VideoStatus;

import java.util.UUID;

@Data
public class VideoResponseDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("userMail")
    private String userMail;

    @JsonProperty("status")
    private VideoStatus status;

    public VideoResponseDTO(String id, String url, String userName, String userMail, VideoStatus status) {
        this.id = id;
        this.url = url;
        this.userName = userName;
        this.userMail = userMail;
        this.status = status;
    }
}
