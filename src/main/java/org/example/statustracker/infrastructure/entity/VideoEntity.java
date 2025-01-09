package org.example.statustracker.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.statustracker.domain.entity.VideoStatus;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VideoEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userMail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VideoStatus status;
}
