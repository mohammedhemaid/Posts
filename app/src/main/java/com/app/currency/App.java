package com.app.currency;

import android.app.Application;

public class App extends Application {
   static ApiRequest apiRequest;

    @Override
    public void onCreate() {
        super.onCreate();
       apiRequest =  RetrofitSingleton.getInstance().build().create(ApiRequest.class);
    }
}
