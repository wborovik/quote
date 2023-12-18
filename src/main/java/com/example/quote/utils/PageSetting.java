package com.example.quote.utils;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public class PageSetting {
    private int page = 0;
    private int size = 10;
    private String field = "id";
    private String order = "asc";

    public Pageable getPageable() {
        return PageRequest.of(page, size, getSort());
    }

    private Sort getSort() {
        if (order.equals("desc")) {
            return Sort.by(field).descending();
        }
        return Sort.by(field).ascending();
    }
}