package com.javarush.task.task35.task3512;

public class Generator<T> {
    private Class<T> cs;

    public Generator(Class<T> cls){
        this.cs = cls;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        return cs.newInstance();
    }
}
