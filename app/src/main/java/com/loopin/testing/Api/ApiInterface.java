package com.loopin.testing.Api;


import com.loopin.testing.Models.ResponseModel;
import com.loopin.testing.Models.SaleModel.SaleDetailModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("users")
    Call<List<ResponseModel>> getResponse();

    // get Sale detail report
    @POST("index.php")
    @FormUrlEncoded
    Call<SaleDetailModel.Reponse> callSale(@Field("API") String api,
                                                     @Field("COMPANY_CODE") String companyCode,
                                                     @Field("from_date") String fromDate,
                                                     @Field("to_date") String toDate,
                                                     @Field("liq_type") String liqType,
                                                     @Field("liq_cat") String liqCat,
                                                     @Field("zone_id") String zoneId,
                                                     @Field("shop_id") String shopId);




}
