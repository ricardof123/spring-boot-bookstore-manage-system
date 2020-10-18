package com.fukuda.bookstore.base.observer;

import java.util.Observable;
import java.util.Observer;

public abstract class BaseObserver<E> implements Observer {
    @Override
    public void update(Observable o, Object arg){
        this.update((E)arg);
    }

    public abstract void update(E e);
}