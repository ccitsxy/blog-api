package com.sxy.blog.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private Integer tid;

    @Column(name = "name")
    private String name;

    @Column(name = "count")
    private Integer count;

    @CreationTimestamp
    @Column(name = "created")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "updated")
    private LocalDateTime updated;

    @ManyToMany(targetEntity = Article.class)
    @JoinTable(name = "article_tag"
            , joinColumns = {@JoinColumn(name = "tid", referencedColumnName = "tid")}
            , inverseJoinColumns = {@JoinColumn(name = "aid", referencedColumnName = "aid")})
    private Set<Article> articles = new LinkedHashSet<>();

    public Integer getTid() {
        return this.tid;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCount() {
        return this.count;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public LocalDateTime getUpdated() {
        return this.updated;
    }

    public Set<Article> getArticles() {
        return this.articles;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
