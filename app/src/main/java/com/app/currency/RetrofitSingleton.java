package com.app.currency;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    static Retrofit.Builder retrofit = null;

    private RetrofitSingleton() {
    }

    public static Retrofit.Builder getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
        }

        return retrofit;
    }
}
