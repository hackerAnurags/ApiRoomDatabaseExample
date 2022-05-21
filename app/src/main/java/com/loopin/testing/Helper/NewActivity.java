package com.loopin.testing.Helper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.loopin.testing.Api.RetrofitController;
import com.loopin.testing.MyDatabase.MyRoomDB;
import com.loopin.testing.R;
import com.loopin.testing.Room.Dao.AddressDao;
import com.loopin.testing.Room.Dao.GeoDao;
import com.loopin.testing.Room.Dao.ResponseDao;
import com.loopin.testing.Room.Entity.AddressEntity;
import com.loopin.testing.Room.Entity.CompanyEntity;
import com.loopin.testing.Room.Entity.GeoEntity;
import com.loopin.testing.Room.Entity.ResponseEntity;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewActivity extends AppCompatActivity {

    List<ResponseModel> models;
    List<AddressModel> model;
    RecyclerView recyclerView;
    MyRoomDB myRoomDB;
    AddressEntity addressEntity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        recyclerView = findViewById(R.id.recycler);
        models = new ArrayList<>();
        model = new ArrayList<>();

        myRoomDB = Room.databaseBuilder(this, MyRoomDB.class, "TestRoom").allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        getData();

        TextView zCode = findViewById(R.id.zCode);
        zCode.setText(myRoomDB.addressDao().getZipCode("90566-7771"));
        myRoomDB.addressDao().updateStreet("vbrghyut784", "90566-7771");
        zCode.setText(myRoomDB.addressDao().getZipCode("90566-7771"));
    }

        private void getData() {
        models.clear();
        model.clear();
        RetrofitController retrofitController = new RetrofitController(getApplicationContext());
        Call<List<ResponseModel>> call = retrofitController.responseModelCall();
        call.enqueue(new Callback<List<ResponseModel>>() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                if (response.isSuccessful()){
                    if (response.body()!=null){
                        List<AddressEntity> list = new ArrayList<AddressEntity>();
                        for (int i =0; i<response.body().size();i++) {
                            models.add(new ResponseModel(response.body().get(i).getId(),
                                    response.body().get(i).getName(),
                                    response.body().get(i).getUsername(),
                                    response.body().get(i).getEmail(),
                                    response.body().get(i).getAddress(),
                                    response.body().get(i).getPhone(),
                                    response.body().get(i).getWebsite(),
                                    response.body().get(i).getCompany()
                            ));
                            myRoomDB.addressDao().insertAddress(new AddressEntity(i+1, response.body().get(i).getAddress().getStreet(),
                                    response.body().get(i).getAddress().getSuite(),
                                    response.body().get(i).getAddress().getCity(),
                                    response.body().get(i).getAddress().getZipcode()));

                            myRoomDB.compDao().insertCompany(new CompanyEntity(i+1,
                                    response.body().get(i).getCompany().getName(),
                                    response.body().get(i).getCompany().getCatchPhrase(),
                                    response.body().get(i).getCompany().getBs()));

                            myRoomDB.responseDao().insertResponse(new ResponseEntity(i+1,
                                    response.body().get(i).getId().toString(),
                                    response.body().get(i).getName(),
                                    response.body().get(i).getUsername(),
                                    response.body().get(i).getEmail(),
                                    response.body().get(i).getPhone(),
                                    response.body().get(i).getWebsite()));


                            myRoomDB.geoDao().insertGeo(new GeoEntity(i+1,
                                    response.body().get(i).getAddress().getGeo().getLat(),
                                    response.body().get(i).getAddress().getGeo().getLng()));

                        }



                        Log.d("TAG..." , models.toString());

                        List<ResponseEntity> resEntity = myRoomDB.responseDao().getAll();
                        List<AddressEntity> addEntity = myRoomDB.addressDao().getAll();
                        List<GeoEntity> geoEntity = myRoomDB.geoDao().getAll();
                        List<CompanyEntity> comEntity = myRoomDB.compDao().getAll();


                        RoomAdapter adapter = new RoomAdapter(resEntity,addEntity,geoEntity,comEntity);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setAdapter(adapter);


//                        NewAdapter adapter = new NewAdapter(models);
//                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//                        recyclerView.setLayoutManager(layoutManager);
//                        recyclerView.setHasFixedSize(true);
//                        recyclerView.setAdapter(adapter);

                    }else {

                        Toast.makeText(NewActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(NewActivity.this, "Check your internet connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {
                Toast.makeText(NewActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("vnfguhrtkuih", t.getMessage());
            }
        });
    }
}