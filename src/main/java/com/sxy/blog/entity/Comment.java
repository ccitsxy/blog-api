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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "article"})
@Entity
@Table(name = "comment")
public class Comment extends Base {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "coid")
    private Integer coid;

    @Column(name = "text")
    private String text;

    @JoinColumn(name = "aid", referencedColumnName = "aid")
    @ManyToOne(targetEntity = Article.class, fetch = FetchType.EAGER)
    private Article article;

    @JsonIgnoreProperties({"parent"})
    @ManyToOne(targetEntity = Comment.class, fetch = FetchType.EAGER)
    private Comment parent;

    @JsonIgnoreProperties({"parent"})
    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private Set<Comment> children = new LinkedHashSet<>();

    @JsonIgnoreProperties({"parent", "comments"})
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    private User user;
}
