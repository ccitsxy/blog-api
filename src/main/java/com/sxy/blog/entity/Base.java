package com.sxy.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class Base {
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "created", insertable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDateTime created;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "updated", insertable = false, columnDefinition = "datetime on update CURRENT_TIMESTAMP")
    private LocalDateTime updated;

    public LocalDateTime getCreated() {
        return this.created;
    }

    public LocalDateTime getUpdated() {
        return this.updated;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
