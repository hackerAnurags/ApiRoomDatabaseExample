package com.loopin.testing.Helper;

import static com.loopin.testing.Helper.AppConst.models;

import android.app.Activity;
import android.widget.Toast;

import androidx.room.Room;

import com.loopin.testing.Api.RetrofitController;
import com.loopin.testing.Models.SaleModel.SaleDetailModel;
import com.loopin.testing.MyDatabase.SaleDatabase;
import com.loopin.testing.Room.Entity.SaleEntity.SaleEntity;
import com.loopin.testing.Room.Entity.SaleEntity.SaleResponseEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MethodCall {



    public static void getAllData(Activity context){
        models.clear();
        SaleDatabase db = Room.databaseBuilder(context,SaleDatabase.class,"Sale_Detail_Report")
                .allowMainThreadQueries().build();
        RetrofitController retrofitController = new RetrofitController(context);
        Call<SaleDetailModel.Reponse> call = retrofitController.saleDetailData("SALE_DETAIL_REPORT",
                "7PH2W","2022/05/20","2022/05/21","All","All","All","All");
        call.enqueue(new Callback<SaleDetailModel.Reponse>() {
            @Override
            public void onResponse(Call<SaleDetailModel.Reponse> call, Response<SaleDetailModel.Reponse> response) {
                if (response.isSuccessful()){
                    if (response.body().getSaleDetailReport()!=null){
                        for (int i =0; i<response.body().getSaleDetailReport().size() ;i++) {
                            models.add(new SaleDetailModel(response.body().getSaleDetailReport().get(i).getShopName(),
                                    response.body().getSaleDetailReport().get(i).getBrandName(),
                                    response.body().getSaleDetailReport().get(i).getSize(),
                                    response.body().getSaleDetailReport().get(i).getType(),
                                    response.body().getSaleDetailReport().get(i).getCategory(),
                                    response.body().getSaleDetailReport().get(i).getQty(),
                                    response.body().getSaleDetailReport().get(i).getMrp(),
                                    response.body().getSaleDetailReport().get(i).getTotalMrpAmount()));

                            db.saleDao().insertSaleData(new SaleEntity(i+1,
                                    response.body().getSaleDetailReport().get(i).getBrandName(),
                                    response.body().getSaleDetailReport().get(i).getShopName(),
                                    response.body().getSaleDetailReport().get(i).getSize(),
                                    response.body().getSaleDetailReport().get(i).getType(),
                                    response.body().getSaleDetailReport().get(i).getCategory(),
                                    response.body().getSaleDetailReport().get(i).getQty(),
                                    response.body().getSaleDetailReport().get(i).getMrp(),
                                    response.body().getSaleDetailReport().get(i).getTotalMrpAmount()));

                        }

                        db.responseDao().insertResponse(new SaleResponseEntity(
                                response.body().getTotalAmout(),
                                response.body().getTotalQty(),
                                response.body().getMsg(),
                                response.body().getError()
                        ));


                    }else {
                        Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SaleDetailModel.Reponse> call, Throwable t) {
                Toast.makeText(context, "Server Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
