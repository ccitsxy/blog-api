package com.sxy.blog.repository;

import com.sxy.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // 根据ID查询分类
    Category getCategoryByCid(Integer cid);

    // 查询所有分类并查询对应文章数
    @Query("select c.cid as cid, c.name as name," +
            "function('date_format',c.created,'%Y-%m-%d %H:%i:%s') as created," +
            "function('date_format',c.updated,'%Y:%m:%d %H:%i:%s') as updated," +
            "size(c.articles) as count from Category c order by cid asc")
    List<Map<String, Object>> findAllAndCount();
}
