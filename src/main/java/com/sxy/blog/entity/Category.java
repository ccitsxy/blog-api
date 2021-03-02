package com.sxy.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "category")
public class Category extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private Integer cid;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "count")
    private Integer count;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    // @OneToMany(targetEntity = Article.class)
    // @JoinColumn(name = "cid", referencedColumnName = "cid")
    // 放弃外键维护权， mappedBy = 对方关系的属性名称
    @OneToMany(mappedBy = "category")
    private Set<Article> articles = new HashSet<>();

    public Category() {
    }

    public Category(Integer cid, String name, Integer count, LocalDateTime created, LocalDateTime updated, Set<Article> articles) {
        this.cid = cid;
        this.name = name;
        this.count = count;
        this.created = created;
        this.updated = updated;
        this.articles = articles;
    }

    public Integer getCid() {
        return this.cid;
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

    public void setCid(Integer cid) {
        this.cid = cid;
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
