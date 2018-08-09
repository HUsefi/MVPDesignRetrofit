package com.example.hassan.webservice.ui.user;

import com.example.hassan.webservice.data.model.User;
import com.example.hassan.webservice.ui.BasePresenter;
import com.example.hassan.webservice.ui.BaseView;

import java.util.List;

public interface UserContract {

    interface View extends BaseView {
        void showLoadedUsers(List<User> userList);

        void showDataNotAvailableToast();

        void showNetworkNotAvailableToast();
    }


    interface Presenter extends BasePresenter<View> {
        void fetchUsersFromRemote();

    }
}
