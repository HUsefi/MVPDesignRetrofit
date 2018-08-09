package com.example.hassan.webservice.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hassan.webservice.R;
import com.example.hassan.webservice.ui.post.ListPostUserFragment;
import com.example.hassan.webservice.ui.user.ListUsersFragment;

public class RetrofitActivity extends AppCompatActivity implements ListUsersFragment.OnClick {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        Fragment listModelFragment = new ListUsersFragment();
        setFragment(listModelFragment);



    }

   void  setFragment(Fragment fragment){
       FragmentManager fragmentManager=getSupportFragmentManager();
       fragmentManager.beginTransaction()
               .replace(R.id.fragment_container,fragment)
               .addToBackStack(null)
               .commit();
    }

    @Override
    public void showComments(int id) {

        setFragment(ListPostUserFragment.newInstance(id));
    }
}
