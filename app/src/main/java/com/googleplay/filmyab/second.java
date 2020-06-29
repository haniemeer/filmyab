package com.googleplay.filmyab;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class second extends AppCompatActivity {
    TextView textViewid;
    RequestQueue queue;
    TextView textViewtitle;
    TextView textViewcount;
    TextView textViewover;
    TextView textViewlang;
    TextView textViewtime;
    ImageView imageView;
    ProgressBar progressBar;
    private String id;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString("id");
        }
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        imageView = (ImageView) findViewById(R.id.imageView2);
        textViewcount = (TextView) findViewById(R.id.textViewcountry);
        textViewid = (TextView) findViewById(R.id.textViewid);
        textViewtitle = (TextView) findViewById(R.id.textViewtitle);
        textViewlang = (TextView) findViewById(R.id.textViewlan);
        textViewtime = (TextView) findViewById(R.id.textViewtime);
        textViewover = (TextView) findViewById(R.id.textoverview);
        queue = Volley.newRequestQueue(this);
        String Ur = "https://api.themoviedb.org/3/movie/" + id + "?api_key=980dc71ca56e596b80a66f62f315a4b2";
        StringRequest stringRequest =new StringRequest(Request.Method.GET, Ur, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {

                    JSONObject jsonObject = new JSONObject(response);
                    textViewid.setText(jsonObject.getString("id"));
                    textViewtitle.setText(jsonObject.getString("orginal_title"));
                    textViewover.setText(jsonObject.getString("overview"));
                    Picasso.with(second.this).load("https://api.themoviedb.org/t/p/w600_and_h900_bestv2" + jsonObject.getString("poster_path")).into(imageView);
                    textViewtime.setText(jsonObject.getString("release_date"));
                    textViewlang.setText(jsonObject.getString("orginal_language"));
                    JSONArray array = jsonObject.getJSONArray("production_countries");
                    JSONObject object = array.getJSONObject(0);
                    textViewcount.setText(object.getString("name"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error =>", error.toString());
            }
        });
        progressBar.setVisibility(View.GONE);
        queue.add(stringRequest);
    }

    }


