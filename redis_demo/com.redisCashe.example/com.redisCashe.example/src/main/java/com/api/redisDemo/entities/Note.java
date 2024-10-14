package com.api.redisDemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="stream_note")
public class Note implements Serializable {
    @Id
    private String id;
    private String title;
    private String content;
    private String addedDate;
    private boolean live=false;

    public Note(String id, String title, String content, String addedDate, boolean live) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.addedDate = addedDate;
        this.live = live;
    }

    //no are constructor
    public Note() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
