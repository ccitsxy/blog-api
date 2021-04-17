package com.sxy.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.sxy.blog.constant.Base;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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

    @JsonView(TagInfo.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private Integer tid;

    @JsonView(TagInfo.class)
    @Column(name = "name", unique = true)
    private String name;
    /*    @ManyToMany(targetEntity = Article.class)
        @JoinTable(name = "article_tag"
                , joinColumns = {@JoinColumn(name = "tid", referencedColumnName = "tid")}
                , inverseJoinColumns = {@JoinColumn(name = "aid", referencedColumnName = "aid")})*/
    // 放弃外键维护权， mappedBy = 对方关系的属性名称 tags
    @JsonIgnoreProperties(value = {"markdown"})
    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
    private Set<Article> articles = new LinkedHashSet<>();

    public interface TagInfo{}
}
