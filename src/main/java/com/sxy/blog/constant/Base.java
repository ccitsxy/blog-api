package com.sxy.blog.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.sxy.blog.entity.Article;
import com.sxy.blog.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Base {

    @JsonView(BaseInfo.class)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "created", insertable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Date created;

    @JsonView(BaseInfo.class)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "updated", insertable = false, columnDefinition = "datetime on update CURRENT_TIMESTAMP")
    private Date updated;

    public interface BaseInfo{}
}
