package org.example.statustracker.adapters.entity;

import jakarta.persistence.*;
import org.example.statustracker.domain.enums.VideoStatus;

@Table(name = "video")
@Entity
public class VideoEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String url;


    @Column(nullable = false)
    private String username;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VideoStatus status;

    public VideoEntity(String id, String url, String username, VideoStatus status) {
        this.id = id;
        this.url = url;
        this.username = username;
        this.status = status;
    }

    public VideoEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
