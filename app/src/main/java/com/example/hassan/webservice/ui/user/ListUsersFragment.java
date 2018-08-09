package com.example.hassan.webservice.ui.user;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hassan.webservice.R;
import com.example.hassan.webservice.data.model.User;
import java.util.ArrayList;
import java.util.List;


public class ListUsersFragment extends Fragment implements UserRecycleAdapter.ItemClickListener,
  UserContract.View{


        private RecyclerView recyclerView;
        private UserRecycleAdapter  userRecycleAdapter;
        private UserContract.Presenter mPresenter;
        private OnListUserFragmentInteraction interaction;
        private List<User> users = new ArrayList<>();


    public ListUsersFragment() {
        // Required empty public constructor
    }

    public static ListUsersFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ListUsersFragment fragment = new ListUsersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListUserFragmentInteraction) {
            interaction = (OnListUserFragmentInteraction) context;
        } else {
            throw new ClassCastException("Not Instance Of OnListUserFragmentInteraction");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_list_user, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view_list_modle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        setAdapter( users);
        return view;
    }

//    private void userRequest() {
//        APIClient apiClient=new APIClient();
//        APIInterface service = apiClient.getClient().create(APIInterface.class);
//        Call<List<User>> usersList = service.getUsers();
//        usersList.enqueue(new Callback<List<User>>() {
//            @Override
//            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                if(response.isSuccessful()){
//                    users =response.body();
//                    userRecycleAdapter = new UserRecycleAdapter(getContext(), users,
//                            ListUsersFragment.this);
//                    recyclerView.setAdapter(userRecycleAdapter);
//            }
//            }
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable t) {
//                if(t instanceof IOException){
//                    Toast.makeText(getContext(), "Connection problem!!!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//    }




    @Override
    public void showLoadedUsers(List<User> userList) {
        userRecycleAdapter.setUsers(userList);
    }

    @Override
    public void showDataNotAvailableToast() {
        Toast.makeText(getContext(), "Data is not available now...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNetworkNotAvailableToast() {
        Toast.makeText(getContext(), "Check you network connection...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.fetchUsersFromRemote();
    }


    public void setAdapter(List<User> users) {
        userRecycleAdapter = new UserRecycleAdapter(ListUsersFragment.this);
        recyclerView.setAdapter(userRecycleAdapter);
    }


    public interface OnClick {
        void showComments(int id);
    }

    @Override
    public void onItemClick(View view, int position) {
        ((ListUsersFragment.OnClick) getContext()).showComments(users.get(position).getId());
    }


    public interface OnListUserFragmentInteraction {
        void onUserItemClicked(int userId);
    }

}