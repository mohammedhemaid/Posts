package com.app.posts.api;

import com.app.posts.posts.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequest {
    @GET("posts")
    Call<List<Post>> getPost();

    @FormUrlEncoded
    @POST("posts")
    Call<Post> Post(@Field("userId") int userId,
                    @Field("id") int id,
                    @Field("title") String title,
                    @Field("body") String body);
}
