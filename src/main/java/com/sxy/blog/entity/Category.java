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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "category")
public class Category extends Base {

    @JsonView(CategoryInfo.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private Integer cid;

    @JsonView(CategoryInfo.class)
    @Column(name = "name", unique = true)
    private String name;

    // @OneToMany(targetEntity = Article.class)
    // @JoinColumn(name = "cid", referencedColumnName = "cid")
    // 放弃外键维护权， mappedBy = 对方关系的属性名称 category
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private Set<Article> articles = new LinkedHashSet<>();

    public interface CategoryInfo extends BaseInfo{}

    public interface CategoryDetail extends CategoryInfo, JsonPage.JsonViews {}
}
