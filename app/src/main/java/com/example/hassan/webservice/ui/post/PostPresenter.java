package com.example.hassan.webservice.ui.post;

import android.content.Context;

import com.example.hassan.webservice.data.model.Post;
import com.example.hassan.webservice.data.sourse.DataSource;
import com.example.hassan.webservice.data.sourse.Repository;
import com.example.hassan.webservice.data.sourse.remote.RemoteDataSource;

import java.util.List;

public class PostPresenter implements PostContract.Presenter {


    private PostContract.View mView;
    private Repository postRepository;
    private static final String TAG = "PostPresenter";

    public PostPresenter(Context context) {
        postRepository = Repository.getINSTANCE(new RemoteDataSource(context));
    }

    @Override
    public void fetchPostOfUserById(int userId) {
        postRepository.getUsersPostById(new DataSource.LoadPostCallback() {
            @Override
            public void onPostsLoaded(List<Post> postList) {
                mView.showLoadedPosts(postList);
            }

            @Override
            public void onDataNotAvailable() {
                mView.showDataNotAvailableToast();
            }

            @Override
            public void onNetworkNotAvailable() {
                mView.showDataNotAvailableToast();
            }
        }, userId);
    }

    @Override
    public void attachView(PostContract.View view) {
        mView = view;
    }

    @Override
    public void detachView(PostContract.View view) {
        mView = view;
    }

    @Override
    public boolean isAttached() {
        return mView != null;
    }
}
