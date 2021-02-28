package com.sxy.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@Entity
@Table(name = "tag")
public class Tag extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private Integer tid;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "count")
    private Integer count;

    @ManyToMany(targetEntity = Article.class)
    @JoinTable(name = "article_tag"
            , joinColumns = {@JoinColumn(name = "tid", referencedColumnName = "tid")}
            , inverseJoinColumns = {@JoinColumn(name = "aid", referencedColumnName = "aid")})
    private List<Article> articles;

    public Integer getTid() {
        return this.tid;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCount() {
        return this.count;
    }

    public List<Article> getArticles() {
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

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
