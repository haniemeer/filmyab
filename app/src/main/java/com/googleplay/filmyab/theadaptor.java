package com.googleplay.filmyab;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class theadaptor extends BaseAdapter {
    ArrayList<list_Data>listdata;
    Context context;
    int resource;
    public theadaptor(@NonNull Context context,int resource,@NonNull ArrayList<list_Data> listdata){

        this.listdata=listdata;
        this.context=context;
        this.resource=resource;
    }

    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public Object getItem(int position) {
        return listdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public  View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if ((convertView==null)){
            LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                    convertView=layoutInflater.inflate(R.layout.grid_list,null,true);

        }
        list_Data list_data=listdata.get(position);
        ImageView img=(ImageView)convertView.findViewById(R.id.img_View);
        Picasso.with(context)

                .load("https://image.tmdb.org/t/p/w600_and_h900_bestv2/"+list_data.getImgeurl())
           .into(img);

        return convertView;

    }
}
