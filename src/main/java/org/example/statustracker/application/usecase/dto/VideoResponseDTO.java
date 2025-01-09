package org.example.statustracker.application.usecase.dto;

import lombok.*;
import org.example.statustracker.domain.entity.VideoStatus;

import java.util.UUID;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VideoResponseDTO {

    private String id;

    private String url;

    private String userName;

    private String userMail;

    private VideoStatus status;

}
