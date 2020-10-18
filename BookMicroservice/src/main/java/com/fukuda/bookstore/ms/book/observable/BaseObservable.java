package com.fukuda.bookstore.ms.book.observable;

import com.fukuda.bookstore.base.observer.BaseObserver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Observable;
import java.util.Set;

public abstract class BaseObservable<E> extends Observable {
    @Autowired
    private Set<BaseObserver<E>> mObservers;

    public BaseObservable(){
    }

    @PostConstruct
    private void Init(){
        mObservers.stream().forEach((o) -> {
            this.addObserver(o);
        });
    }

    public void notify(E e){
        this.setChanged();
        this.notifyObservers(e);
    }
}