package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model{
    private ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        return this.modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("serg", 1L, 21));
        users.add(new User("serg2", 2L, 22));
        users.add(new User("serg3", 3L, 23));
        users.add(new User("serg4", 4L, 24));
        users.add(new User("serg5", 5L, 25));
        modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
}
