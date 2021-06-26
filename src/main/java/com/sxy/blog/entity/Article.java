package com.sxy.blog.entity;

import com.sxy.blog.constant.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

// 文章表
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "article")
public class Article extends Base {
    // 文章ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;

    // 标题
    @Column(length = 50)
    private String title;

    // 简介
    @Column(length = 200)
    private String description;

    // Markdown 正文
    @Column(columnDefinition = "longtext")
    private String markdown;

    // 分类
    @ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    private Category category;

    // 标签
    @ManyToMany(targetEntity = Tag.class, fetch = FetchType.EAGER)
    @JoinTable(name = "article_tag"
            , joinColumns = {@JoinColumn(name = "aid", referencedColumnName = "aid")}
            , inverseJoinColumns = {@JoinColumn(name = "tid", referencedColumnName = "tid")})
    private Set<Tag> tags = new LinkedHashSet<>();
}
