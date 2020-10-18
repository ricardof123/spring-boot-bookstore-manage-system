package com.fukuda.bookstore.ms.book.service;

import com.fukuda.bookstore.ms.book.entity.BaseEntity;
import com.fukuda.bookstore.ms.book.form.BaseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class BaseCrudServiceImpl<E extends BaseEntity, F extends BaseForm<E>, R extends CrudRepository<E, Integer>> implements BaseCrudService<E, F>{
    @Autowired
    protected R mRepository;

    public Iterable<E> findAll(){
        return mRepository.findAll();
    }

    public Optional<E> findById(Integer id) {
        return mRepository.findById(id);
    }

    public void deleteById(Integer id){
        mRepository.deleteById(id);
    }

    public abstract E create(F form);

    public abstract E update(Integer id, F  form);
}
