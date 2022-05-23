package com.loopin.testing.Api;

import android.content.Context;

import com.loopin.testing.Models.ResponseModel;
import com.loopin.testing.Models.SaleModel.SaleDetailModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitController {
    private ApiInterface apiInterface;
    private static RetrofitController retrofitController = null;
    private Retrofit retrofit;
    private String loopBaseUrl = "http://api.iposindia.com/android/";
    private String otherUrl = "https://jsonplaceholder.typicode.com/";


    public static RetrofitController getInstance(Context context){
        if (retrofitController==null){
            retrofitController = new RetrofitController(context);
        }
        return retrofitController;
    }

    private Retrofit getRetrofit(){
        retrofit = new Retrofit.Builder().baseUrl(loopBaseUrl)
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

    public Call<SaleDetailModel.Reponse> saleDetailData(String api, String companyCode, String fDate,
                                                        String toDate, String liqType,
                                                        String liqCat, String zoneId, String shopId){
        return apiInterface.callSale(api, companyCode, fDate,toDate,liqType,liqCat,zoneId,shopId);
    }
}
