package org.example.statustracker.application.usecase.dto;

import lombok.*;
import org.example.statustracker.domain.entity.VideoStatus;

import java.util.UUID;

@Data
public class VideoResponseDTO {

    private String id;

    private String url;

    private String userName;

    private String userMail;

    private VideoStatus status;

    public VideoResponseDTO(String id, String url, String userName, String userMail, VideoStatus status) {
        this.id = id;
        this.url = url;
        this.userName = userName;
        this.userMail = userMail;
        this.status = status;
    }
}
