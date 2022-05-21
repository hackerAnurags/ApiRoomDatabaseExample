package com.loopin.testing.Api;


import com.loopin.testing.Helper.ResponseModel;
import com.loopin.testing.Room.Entity.AddressEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("users")
    Call<List<ResponseModel>> getResponse();



}
