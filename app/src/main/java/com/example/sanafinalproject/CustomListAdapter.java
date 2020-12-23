package com.example.sanafinalproject;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ViewHolder> {
    private ArrayList<Custom> CustomArrayList=new ArrayList<>();
    private Context context;

    public CustomListAdapter(Context context, ArrayList<Custom> CustomArrayList) {
        this.CustomArrayList=CustomArrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public CustomListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_item_list,viewGroup,false);
        return new CustomListAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CustomListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.Custom_name.setText(CustomArrayList.get(i).getName());
        //viewHolder.Custom_desc.setText(CustomArrayList.get(i).getCustom().getLogin());

        final Custom CustomArrayList = this.CustomArrayList.get(i);
        viewHolder.Custom_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,CustomDetail.class);

                intent.putExtra("CustomName",CustomArrayList.getName());
                intent.putExtra("CustomLogin",CustomArrayList.getLogin());
                intent.putExtra("CustomFullName",CustomArrayList.getFull_name());

               // intent.putExtra("Owner",  CustomArrayList.getCustom().getLogin());


                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return CustomArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        //private ImageView Custom_image;
        private TextView Custom_name,Custom_desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Custom_image=(ImageView)itemView.findViewById(R.id.Custom_image);
            Custom_name=(TextView) itemView.findViewById(R.id.car_name);
            Custom_desc=(TextView)itemView.findViewById(R.id.car_desc);
        }
    }
}