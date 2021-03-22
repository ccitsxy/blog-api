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
@Table(name = "tag")
public class Tag extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private Integer tid;

    @Column(name = "name", unique = true)
    private String name;
    /*    @ManyToMany(targetEntity = Article.class)
        @JoinTable(name = "article_tag"
                , joinColumns = {@JoinColumn(name = "tid", referencedColumnName = "tid")}
                , inverseJoinColumns = {@JoinColumn(name = "aid", referencedColumnName = "aid")})*/
    // 放弃外键维护权， mappedBy = 对方关系的属性名称 tags
    @ManyToMany(mappedBy = "tags")
    private Set<Article> articles = new LinkedHashSet<>();
}
