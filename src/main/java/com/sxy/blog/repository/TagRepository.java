package com.sxy.blog.repository;

import com.sxy.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TagRepository extends JpaRepository<Tag, Integer>, JpaSpecificationExecutor<Tag> {
    Tag getTagByTid(Integer tid);

    @Query("select t.tid as tid, t.name as name," +
            "function('date_format',t.created,'%Y-%m-%d %H:%i:%s') as created," +
            "function('date_format',t.updated,'%Y:%m:%d %H:%i:%s') as updated," +
            "size(t.articles) as count from Tag t order by tid asc")
    List<Map<String, Object>> findAllAndCount();
}
