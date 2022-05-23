package com.loopin.testing.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import static com.loopin.testing.Helper.MethodCall.getAllData;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeechService;
import android.view.View;
import android.widget.TextView;

import com.loopin.testing.Adapter.SaleAdpater.SaleRoomAdapter;
import com.loopin.testing.MyDatabase.SaleDatabase;
import com.loopin.testing.R;
import com.loopin.testing.Room.Dao.SaleDao.SaleDao;
import com.loopin.testing.Room.Entity.ResponseEntity;
import com.loopin.testing.Room.Entity.SaleEntity.SaleEntity;
import com.loopin.testing.Room.Entity.SaleEntity.SaleResponseEntity;

import java.util.List;

public class SaleActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private TextView grandQuantity,grandAmount;
    SaleDatabase db;
    List<SaleEntity> list;
    SaleResponseEntity res;
    TextView clickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
        recyclerView = findViewById(R.id.saleDetailRecycler);
        grandQuantity = findViewById(R.id.grandQty);
        grandAmount = findViewById(R.id.grandMrp);
        clickMe = findViewById(R.id.clickMe);

        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RoomQueryTest.class);
                startActivity(intent);
            }
        });
        db = Room.databaseBuilder(this, SaleDatabase.class, "Sale_Detail_Report").
                allowMainThreadQueries().build();

        list = db.saleDao().getAll();
        res = db.responseDao().getAll();
        getAllData(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        SaleRoomAdapter saleRoomAdapter = new SaleRoomAdapter(list);
        recyclerView.setAdapter(saleRoomAdapter);
        grandAmount.setText(String.valueOf(res.totalAmout));
        grandQuantity.setText(String.valueOf(res.totalQty));

    }

//    private void getAllData(){
//        models.clear();
//        RetrofitController retrofitController = new RetrofitController(getApplicationContext());
//        Call<SaleDetailModel.Reponse> call = retrofitController.saleDetailData("SALE_DETAIL_REPORT",
//                "7PH2W","2022/05/20","2022/05/21","All","All","All","All");
//        call.enqueue(new Callback<SaleDetailModel.Reponse>() {
//            @Override
//            public void onResponse(Call<SaleDetailModel.Reponse> call, Response<SaleDetailModel.Reponse> response) {
//                if (response.isSuccessful()){
//                    if (response.body().getSaleDetailReport()!=null){
//                        for (int i =0; i<response.body().getSaleDetailReport().size() ;i++) {
//                            models.add(new SaleDetailModel(response.body().getSaleDetailReport().get(i).getShopName(),
//                                    response.body().getSaleDetailReport().get(i).getBrandName(),
//                                    response.body().getSaleDetailReport().get(i).getSize(),
//                                    response.body().getSaleDetailReport().get(i).getType(),
//                                    response.body().getSaleDetailReport().get(i).getCategory(),
//                                    response.body().getSaleDetailReport().get(i).getQty(),
//                                    response.body().getSaleDetailReport().get(i).getMrp(),
//                                    response.body().getSaleDetailReport().get(i).getTotalMrpAmount()));
//
//                            db.saleDao().insertSaleData(new SaleEntity(i+1,
//                                    response.body().getSaleDetailReport().get(i).getBrandName(),
//                                    response.body().getSaleDetailReport().get(i).getShopName(),
//                                    response.body().getSaleDetailReport().get(i).getSize(),
//                                    response.body().getSaleDetailReport().get(i).getType(),
//                                    response.body().getSaleDetailReport().get(i).getCategory(),
//                                    response.body().getSaleDetailReport().get(i).getQty(),
//                                    response.body().getSaleDetailReport().get(i).getMrp(),
//                                    response.body().getSaleDetailReport().get(i).getTotalMrpAmount()));
//
//                        }
//                        adapter = new SaleDetailAdapter(models,getApplicationContext());
//                        recyclerView.setAdapter(adapter);
//
//                        db.responseDao().insertResponse(new SaleResponseEntity(
//                                response.body().getTotalAmout(),
//                                response.body().getTotalQty(),
//                                response.body().getMsg(),
//                                response.body().getError()
//                                ));
//                        grandQuantity.setText(String.valueOf(response.body().getTotalQty()));
//                        grandAmount.setText(String.valueOf(response.body().getTotalAmout()));
//
//
//                    }else {
//                        Toast.makeText(SaleActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
//                    }
//                }else {
//                    Toast.makeText(SaleActivity.this, "Check your internet connection", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SaleDetailModel.Reponse> call, Throwable t) {
//                Toast.makeText(SaleActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}