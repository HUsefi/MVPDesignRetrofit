package com.example.hassan.webservice.ui.user;



import android.content.Context;

import com.example.hassan.webservice.data.model.User;
import com.example.hassan.webservice.data.sourse.DataSource;
import com.example.hassan.webservice.data.sourse.Repository;
import com.example.hassan.webservice.data.sourse.remote.RemoteDataSource;

import java.util.List;

public class UserPresenter implements UserContract.Presenter{

   private UserContract.View mView;
   private Repository userRepository;

    public UserPresenter(Context context) {
    this.userRepository = Repository.getINSTANCE(new RemoteDataSource(context));
      }

    @Override
    public void fetchUsersFromRemote() {
     userRepository.getUsers(new DataSource.LoadUsersCallback() {
      @Override
      public void onUsersLoaded(List<User> userList) {
       mView.showLoadedUsers(userList);
      }

      @Override
      public void onDataNotAvailable() {
       mView.showDataNotAvailableToast();
      }

      @Override
      public void onNetworkNotAvailable() {
       mView.showNetworkNotAvailableToast();
      }
     });

    }

    @Override
    public void attachView(UserContract.View view) {
     mView = view;
    }

    @Override
    public void detachView(UserContract.View view) {
     mView = view;
    }

    @Override
    public boolean isAttached() {
     return mView != null;
    }
}
