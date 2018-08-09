package com.example.hassan.webservice.data.sourse;

import com.example.hassan.webservice.data.model.Post;
import com.example.hassan.webservice.data.model.User;

import java.util.List;

public interface DataSource {

    interface LoadUsersCallback {
        void onUsersLoaded(List<User> userList);

        void onDataNotAvailable();

        void onNetworkNotAvailable();
    }


    interface LoadPostCallback {
        void onPostsLoaded(List<Post> postList);

        void onDataNotAvailable();

        void onNetworkNotAvailable();
    }

    void getUsers(LoadUsersCallback callbacks);


    void getUsersPostById(LoadPostCallback callbacks, int userId);


}
