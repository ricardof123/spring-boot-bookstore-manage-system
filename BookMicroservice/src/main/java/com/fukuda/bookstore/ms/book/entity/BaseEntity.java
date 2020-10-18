package com.fukuda.bookstore.ms.book.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Version
    @Column(name = "updated_at")
    protected Timestamp updatedAt;

    public BaseEntity(){
    }

    public Integer getId() {
        return id;
    }
}
