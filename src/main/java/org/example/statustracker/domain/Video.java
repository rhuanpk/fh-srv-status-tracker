package org.example.statustracker.domain;

import org.example.statustracker.domain.enums.VideoStatus;
import org.example.statustracker.domain.exception.BusinessException;

public class Video {

    private String id;

    private String url;

    private String username;

    private VideoStatus status;

    public Video() {
    }

    public Video(String id, String url, String username, VideoStatus status) {
        this.id = id;
        this.url = url;
        this.username = username;

        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new BusinessException("Usuário não pode ser nulo");
        }
        this.username = username;
    }

    public VideoStatus getStatus() {
        return status;
    }

    public void setStatus(VideoStatus status) {
        if (status == null) {
            throw new BusinessException("Status não pode ser nulo");
        }
        this.status = status;
    }
}
