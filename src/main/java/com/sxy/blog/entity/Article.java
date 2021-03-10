package com.sxy.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sxy.blog.constant.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "article")
public class Article extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private Integer aid;

    @Column(name = "title")
    private String title;

    @Column(name = "markdown", columnDefinition = "longtext")
    private String markdown;

    @Column(name = "html", columnDefinition = "longtext")
    private String html;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    private Category category;

    @ManyToMany(targetEntity = Tag.class)
    @JoinTable(name = "article_tag"
            , joinColumns = {@JoinColumn(name = "aid", referencedColumnName = "aid")}
            , inverseJoinColumns = {@JoinColumn(name = "tid", referencedColumnName = "tid")})
    private Set<Tag> tags = new LinkedHashSet<>();
}
