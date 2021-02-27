package com.sxy.blog.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "article")
public class Article {
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

    @CreationTimestamp
    @Column(name = "created")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "updated")
    private LocalDateTime updated;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    private Category category;

    @ManyToMany(targetEntity = Tag.class)
    @JoinTable(name = "article_tag"
            , joinColumns = {@JoinColumn(name = "aid", referencedColumnName = "aid")}
            , inverseJoinColumns = {@JoinColumn(name = "tid", referencedColumnName = "tid")})
    private List<Tag> tags;

    public Integer getAid() {
        return this.aid;
    }

    public String getTitle() {
        return this.title;

    }

    public String getMarkdown() {
        return this.markdown;
    }

    public String getHtml() {
        return this.html;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public LocalDateTime getUpdated() {
        return this.updated;
    }

    public Category getCategory() {
        return this.category;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
