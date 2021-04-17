package com.sxy.blog.constant;

import com.fasterxml.jackson.annotation.JsonView;
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

    public interface JsonViews{}

    @JsonView(JsonViews.class)
    public int getTotalPages() {
        return super.getTotalPages();
    }

    @JsonView(JsonViews.class)
    public long getTotalElements() {
        return super.getTotalElements();
    }

    @JsonView(JsonViews.class)
    public boolean hasNext() {
        return super.hasNext();
    }

    @JsonView(JsonViews.class)
    public boolean isLast() {
        return super.isLast();
    }

    @JsonView(JsonViews.class)
    public boolean hasContent() {
        return super.hasContent();
    }

    @JsonView(JsonViews.class)
    public List<T> getContent() {
        return super.getContent();
    }
}
