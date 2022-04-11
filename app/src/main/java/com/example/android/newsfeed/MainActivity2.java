package com.example.android.newsfeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements onAdapterItemClickListener {
    private RecyclerView mRecyclerView;
    Intent intent;
    RecyclerViewAdapter mRecyclerViewAdapter;
    ArrayList<data> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        intent = getIntent();
        String mUrl = intent.getStringExtra("url");
        ParseJson(mUrl);

    }

    public void ParseJson(String mUrl) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("articles");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                JSONObject jsonObject1 = jsonObject.getJSONObject("source");
                                String source = jsonObject1.getString("name");
                                String description = jsonObject.getString("description");
                                String title = jsonObject.getString("title");
                                String url = jsonObject.getString("url");
                                String urlToImage = jsonObject.getString("urlToImage");
                                mData.add(new data (source, title, description,url, urlToImage));

                            }
                            mRecyclerViewAdapter = new RecyclerViewAdapter(MainActivity2.this, mData, MainActivity2.this);
                            mRecyclerView.setAdapter(mRecyclerViewAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("EeRrOr", "not working " + error.toString());
            }
        });
//        mRequestQueue.add(jsonObjectRequest);
        Singleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public void onItemClick(int position) {
        data data = mData.get(position);
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(data.getUrl()));

    }
}
