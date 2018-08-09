package com.example.hassan.webservice.data.sourse.remote;

import com.example.hassan.webservice.data.model.Post;
import com.example.hassan.webservice.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET ("users")
    Call<List<User>> getUsers();

    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int id) ;
}
