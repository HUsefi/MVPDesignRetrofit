package com.example.hassan.webservice.data.sourse;

import com.example.hassan.webservice.data.sourse.remote.RemoteDataSource;

public class Repository implements DataSource {

  public static Repository INSTANCE=null;
  private RemoteDataSource remoteDataSource;


    public Repository(RemoteDataSource remoteDataSource) {
        //no instance
        if (remoteDataSource instanceof RemoteDataSource) {
            this.remoteDataSource = (RemoteDataSource) remoteDataSource;
        } else {
            throw new ClassCastException("IS NOT INSTANCE OF RemoteDataSource");
        }
    }


    public static Repository getINSTANCE(DataSource remoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new Repository((RemoteDataSource) remoteDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void getUsers(LoadUsersCallback callbacks) {
       // remoteDataSource.getUsers(callbacks);

    }

    @Override
    public void getUsersPostById(LoadPostCallback callbacks, int userId) {
      //  remoteDataSource.getUsersPostById(callbacks, userId);
    }
}
