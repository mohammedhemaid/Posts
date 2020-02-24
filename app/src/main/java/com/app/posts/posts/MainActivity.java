package com.app.posts.posts;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.posts.R;
import com.app.posts.adapter.RecycleViewAdapter;
import com.app.posts.addpost.AddPostActivity;
import com.app.posts.init.App;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    final static int REQUEST_ADD_POST = 101;
    RecycleViewAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecycleView();
        getAllPost();


        findViewById(R.id.add_post).setOnClickListener((View v) -> {
            Intent i = new Intent(MainActivity.this, AddPostActivity.class);
            startActivityForResult(i, REQUEST_ADD_POST);
        });
    }

    private void initRecycleView() {
        adapter = new RecycleViewAdapter();
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setAdapter(adapter);
    }

    private void getAllPost() {
        App.apiRequest.getPost().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> listOfPosts = response.body();
                adapter.setData(listOfPosts);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {}
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ADD_POST) {
            if (resultCode == RESULT_OK) {
                getAllPost();
            }
        }
    }
}
