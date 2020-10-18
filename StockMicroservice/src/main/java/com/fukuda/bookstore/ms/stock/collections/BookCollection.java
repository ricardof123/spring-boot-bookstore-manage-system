package com.fukuda.bookstore.ms.stock.collections;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.persistence.onheap.OnHeapPersistence;
import org.springframework.stereotype.Component;

public class BookCollection extends ConcurrentIndexedCollection {
    public BookCollection(){
        super(new OnHeapPersistence(new BookCollectionIndex()));
    }
}
