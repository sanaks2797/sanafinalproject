package com.example.sanafinalproject;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    ArrayList<Custom> CustomArrayList=new ArrayList<>();
    private CustomListAdapter CustomListAdapter;
    private RecyclerView Custom_recyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Custom_recyclerview=(RecyclerView)findViewById(R.id.RecyclerView);
        Custom_recyclerview.setLayoutManager(new LinearLayoutManager(this));

        getCarsResponse();
    }
    private void getCarsResponse() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RInterface requestInteface=retrofit.create(RInterface.class);
        Call<List<Custom>> call=requestInteface.getCarsJson();


        call.enqueue(new Callback<List<Custom>>() {
            @Override
            public void onResponse(Call<List<Custom>> call, Response<List<Custom>> response) {
                CustomArrayList=new ArrayList<>(response.body());
                CustomListAdapter=new CustomListAdapter(MainActivity.this,CustomArrayList);
                Custom_recyclerview.setAdapter(CustomListAdapter);
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Custom>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
            }


        });
    }

}