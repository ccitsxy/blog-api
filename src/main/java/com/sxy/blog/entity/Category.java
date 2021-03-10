package com.sxy.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sxy.blog.constant.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    // @OneToMany(targetEntity = Article.class)
    // @JoinColumn(name = "cid", referencedColumnName = "cid")
    // 放弃外键维护权， mappedBy = 对方关系的属性名称
    @OneToMany(mappedBy = "category")
    private Set<Article> articles = new LinkedHashSet<>();
}
