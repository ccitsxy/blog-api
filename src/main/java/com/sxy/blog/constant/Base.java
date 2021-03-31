package com.sxy.blog.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Base {
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "created", insertable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDateTime created;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "updated", insertable = false, columnDefinition = "datetime on update CURRENT_TIMESTAMP")
    private LocalDateTime updated;
}
