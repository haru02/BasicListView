package com.kimhyojung.android.basiclistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    public static ArrayList<RecyclerData> datas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        datas = new ArrayList<>();

        for(int i=0;i<100;i++){
            RecyclerData data = new RecyclerData();

            data.title = i+" Rolling in the deep";
            data.name = "pichachu";
            data.image = R.mipmap.pikachu2;
            datas.add(data);
        }

        RecyclerView listView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter adapter = new RecyclerAdapter(datas, R.layout.activity_recycler_item, this);
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(this));
    }
}
