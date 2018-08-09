package com.example.hassan.webservice.data.model;

import java.util.List;

public class UserResponse {

    private List<User> users;

    public UserResponse(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
