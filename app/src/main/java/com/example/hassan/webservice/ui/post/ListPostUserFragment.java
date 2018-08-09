package com.example.hassan.webservice.ui.post;


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
import com.example.hassan.webservice.data.model.Post;
import com.example.hassan.webservice.data.sourse.remote.APIClient;
import com.example.hassan.webservice.data.sourse.remote.APIInterface;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListPostUserFragment extends Fragment  implements PostContract.View {
    RecyclerView recyclerView;
    private int userId;

    private PostContract.Presenter mPresenter;
    private PostRecycleAdapter adapter;

    public ListPostUserFragment() {
        // Required empty public constructor
        adapter=new PostRecycleAdapter();
    }

    public static ListPostUserFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("UserId", id);
        ListPostUserFragment fragment = new ListPostUserFragment();
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        userId = getArguments().getInt("UserId");
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_post_user, container, false);

        adapter = new PostRecycleAdapter();
        mPresenter = new PostPresenter(getContext());
        mPresenter.attachView(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.list_post_user);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       // userRequest();
        return view;
    }

//    private void userRequest() {
//        APIClient apiClient = new APIClient();
//        APIInterface service = apiClient.getClient().create(APIInterface.class);
//        Call<List<Post>> postsList = service.getPosts(userId);
//
//        postsList.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                if (response.isSuccessful()) {
//                    List<Post> listPost = response.body();
//                    PostRecycleAdapter postRecycleAdapter = new PostRecycleAdapter();
//                    recyclerView.setAdapter(postRecycleAdapter);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                if (t instanceof IOException) {
//                    Toast.makeText(getContext(), "Connection problem!!!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//}


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.fetchPostOfUserById(getArguments().getInt("userId"));
    }

    @Override
    public void onDestroyView() {
        mPresenter.detachView(this);
        super.onDestroyView();

    }


    @Override
    public void showLoadedPosts(List<Post> postList) {
        adapter.setPosts(postList);
    }

    @Override
    public void showDataNotAvailableToast() {
        Toast.makeText(getContext(), "Data is not available now...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNetworkNotAvailableToast() {
        Toast.makeText(getContext(), "Check you network connection...", Toast.LENGTH_SHORT).show();
    }
}
