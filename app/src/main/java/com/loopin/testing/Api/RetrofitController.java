package com.loopin.testing.Api;

import android.content.Context;

import com.loopin.testing.Helper.ResponseModel;
import com.loopin.testing.Room.Entity.AddressEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitController {
    private ApiInterface apiInterface;
    private static RetrofitController retrofitController = null;
    private Retrofit retrofit;


    public static RetrofitController getInstance(Context context){
        if (retrofitController==null){
            retrofitController = new RetrofitController(context);
        }
        return retrofitController;
    }

    private Retrofit getRetrofit(){
        retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
               // .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    public RetrofitController(Context context){
        apiInterface = getRetrofit().create(ApiInterface.class);
    }

    public Call<List<ResponseModel>> responseModelCall(){
        return apiInterface.getResponse();
    }
}
