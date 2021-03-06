package com.sxy.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sxy.blog.constant.Base;
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
@Entity
@Table(name = "category")
public class Category extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @Column(length = 20, unique = true)
    private String name;

    // @OneToMany(targetEntity = Article.class)
    // @JoinColumn(name = "cid", referencedColumnName = "cid")
    // 放弃外键维护权， mappedBy = 对方关系的属性名称 category
    @JsonBackReference
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<Article> articles = new LinkedHashSet<>();
}
