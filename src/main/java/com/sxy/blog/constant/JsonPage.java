package com.sxy.blog.constant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class JsonPage<T> extends PageImpl<T> {
    public JsonPage(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public JsonPage(List<T> content) {
        super(content);
    }

    public JsonPage(Page<T> page, final Pageable pageable) {
        super(page.getContent(), pageable, page.getTotalElements());
    }

    public int getTotalPages() {
        return super.getTotalPages();
    }

    public long getTotalElements() {
        return super.getTotalElements();
    }

    public boolean hasNext() {
        return super.hasNext();
    }

    public boolean isLast() {
        return super.isLast();
    }

    public boolean hasContent() {
        return super.hasContent();
    }

    public List<T> getContent() {
        return super.getContent();
    }
}
