package org.example.statustracker.domain.entity;

import org.example.statustracker.domain.exception.BusinessException;

public class Video {

    private String id;

    private String url;

    private String userName;

    private String userMail;

    private VideoStatus status;

    public Video() {
    }

    public Video(String id, String url, String userName, String userMail, VideoStatus status) {
        this.id = id;
        this.url = url;
        this.userName = userName;
        this.userMail = userMail;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName == null || userName.isBlank()) {
            throw new BusinessException("Usuário não pode ser nulo");
        }
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        if (userMail == null || userMail.isBlank()) {
            throw new BusinessException("Email não pode ser nulo");
        }
        this.userMail = userMail;
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
