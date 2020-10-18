package com.fukuda.bookstore.ms.stock.collections;

import com.fukuda.bookstore.base.dto.BookDto;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.query.option.QueryOptions;

public class BookCollectionQuery implements Query<BookDto> {
    private Integer bookId;

    public BookCollectionQuery(Integer bookId){
        this.bookId = bookId;
    }

    @Override
    public boolean matches(BookDto o, QueryOptions queryOptions) {
        return o.getId().equals(this.bookId);
    }
}
