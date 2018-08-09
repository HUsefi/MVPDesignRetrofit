package com.example.hassan.webservice.data.sourse.remote;

import android.content.Context;

import com.example.hassan.webservice.data.model.Post;
import com.example.hassan.webservice.data.model.User;
import com.example.hassan.webservice.data.sourse.DataSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource implements DataSource {
    private APIInterface apiInterface;
    private Call<List<User>> callUserList;
    private Call<List<Post>> callPostList;
    private Context context;

    public RemoteDataSource(Context context) {
        this.context = context;
        apiInterface = APIClient.getClient().create(APIInterface.class);
    }

    @Override
    public void getUsers(final LoadUsersCallback callbacks) {

            callUserList = apiInterface.getUsers();
            callUserList.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    if (response.isSuccessful()) {
                        callbacks.onUsersLoaded(response.body());
                    } else {
                        callbacks.onDataNotAvailable();
                    }

                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    callbacks.onDataNotAvailable();
                }
            });


    }

    @Override
    public void getUsersPostById(final LoadPostCallback callbacks, int userId) {
        callPostList = apiInterface.getPosts(userId);
        callPostList.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    callbacks.onPostsLoaded(response.body());
                } else {
                    callbacks.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                callbacks.onDataNotAvailable();
            }
        });


    }
}
