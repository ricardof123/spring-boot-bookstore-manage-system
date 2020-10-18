package com.fukuda.bookstore.ms.stock.collections;

import com.fukuda.bookstore.base.dto.BookDto;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

public class BookCollectionIndex extends SimpleAttribute<BookDto, Integer> {
    public BookCollectionIndex(){
    }

    @Override
    public Integer getValue(BookDto o, QueryOptions queryOptions) {
        return o.getId();
    }
}