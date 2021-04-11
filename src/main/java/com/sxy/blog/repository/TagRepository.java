package com.sxy.blog.repository;

import com.sxy.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag getTagByTid(Integer tid);
}
