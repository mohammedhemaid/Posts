package com.app.posts.init;

import android.app.Application;

import com.app.posts.api.ApiRequest;
import com.app.posts.api.RetrofitSingleton;

public class App extends Application {

   public static ApiRequest apiRequest;

    @Override
    public void onCreate() {
        super.onCreate();
       apiRequest =  RetrofitSingleton.getInstance().build().create(ApiRequest.class);
    }
}
