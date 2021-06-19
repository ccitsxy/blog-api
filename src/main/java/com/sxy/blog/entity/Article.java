package com.sxy.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.sxy.blog.constant.Base;
import com.sxy.blog.constant.JsonPage;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "article")
public class Article extends Base {
    // 文章ID
    @JsonView({ArticleList.class, ArticleInfo.class, ArticleDetail.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private Integer aid;

    // 标题
    @JsonView({ArticleList.class, ArticleInfo.class, ArticleDetail.class})
    @Column(name = "title", length = 50)
    private String title;

    // 简介
    @JsonView(ArticleInfo.class)
    @Column(name = "description", length = 200)
    private String description;

    // Markdown 正文
    @JsonView(ArticleDetail.class)
    @Column(name = "markdown", columnDefinition = "longtext")
    private String markdown;

    // 分类
    @JsonView({ArticleInfo.class, ArticleDetail.class})
    @JsonIgnoreProperties({"articles", "created", "updated"})
    @ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    private Category category;

    // 标签
    @JsonView({ArticleInfo.class, ArticleDetail.class})
    @JsonIgnoreProperties({"articles", "created", "updated"})
    @ManyToMany(targetEntity = Tag.class, fetch = FetchType.EAGER)
    @JoinTable(name = "article_tag"
            , joinColumns = {@JoinColumn(name = "aid", referencedColumnName = "aid")}
            , inverseJoinColumns = {@JoinColumn(name = "tid", referencedColumnName = "tid")})
    private Set<Tag> tags = new LinkedHashSet<>();

    public interface ArticleList extends BaseInfo {
    }

    public interface ArticleInfo extends JsonPage.JsonViews, BaseInfo, Tag.TagInfo, Category.CategoryInfo {
    }

    public interface ArticleDetail extends JsonPage.JsonViews, BaseInfo, Tag.TagInfo, Category.CategoryInfo {
    }
}
