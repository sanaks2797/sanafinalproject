package com.example.sanafinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomDetail extends AppCompatActivity{
    TextView nameCustom;
    TextView loginCustom;
    TextView fullnameCustom;
    TextView CustomCustom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_detail);

        nameCustom=findViewById(R.id.name);
        loginCustom=findViewById(R.id.login);
        fullnameCustom=findViewById(R.id.fullname);
        CustomCustom=findViewById(R.id.owner);


        Intent intent=getIntent();
        final String Name = intent.getStringExtra("CustomName");
        final String Login = intent.getStringExtra("CustomLogin");
        final String FullName = intent.getStringExtra("CustomFullName");

        //final String Custom = intent.getStringExtra("Owner");


        nameCustom.setText(Name);
        loginCustom.setText(Login);
        fullnameCustom.setText(FullName);

       //CustomCustom.setText(Custom);

    }
}
