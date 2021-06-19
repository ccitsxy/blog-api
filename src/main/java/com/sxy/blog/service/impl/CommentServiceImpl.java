package com.sxy.blog.service.impl;

import com.sxy.blog.constant.JsonPage;
import com.sxy.blog.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Join;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public Page<Comment> findAllByArticle(Integer aid, Integer page, Integer size) {
        Specification<Comment> spec = (root, cq, cb) -> {
            Join<Comment, Article> join = root.join("article");
            return cb.and(root.get("parent").isNull(),
                    cb.equal(join.get("aid"), aid));
        };
        Sort sort = Sort.by(Sort.Order.desc("coid"));
        PageRequest pr = PageRequest.of(page, size, sort);
        return new JsonPage<>(commentRepository.findAll(spec, pr), pr);
    }

    @Override
    public void deleteComment(Integer coid) {
        commentRepository.deleteById(coid);
    }
}
