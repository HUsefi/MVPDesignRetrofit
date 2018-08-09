package com.example.hassan.webservice.ui.post;

import com.example.hassan.webservice.data.model.Post;
import com.example.hassan.webservice.ui.BasePresenter;
import com.example.hassan.webservice.ui.BaseView;

import java.util.List;

public interface PostContract {
    interface View extends BaseView {
        void showLoadedPosts(List<Post> postList);

        void showDataNotAvailableToast();

        void showNetworkNotAvailableToast();
    }

    interface Presenter extends BasePresenter<View> {
        void fetchPostOfUserById(int userId);
    }

}
