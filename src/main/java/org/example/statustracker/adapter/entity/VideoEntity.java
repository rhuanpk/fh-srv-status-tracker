package org.example.statustracker.adapter.entity;

import jakarta.persistence.*;
import org.example.statustracker.core.domain.enums.VideoStatus;

@Table(name = "video")
@Entity
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

    public VideoEntity(String id, String url, String userName, String userMail, VideoStatus status) {
        this.id = id;
        this.url = url;
        this.userName = userName;
        this.userMail = userMail;
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
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public VideoStatus getStatus() {
        return status;
    }

    public void setStatus(VideoStatus status) {
        this.status = status;
    }
}
