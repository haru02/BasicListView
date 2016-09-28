package com.kimhyojung.android.basiclistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BasicGridActivity extends AppCompatActivity {

    String datas[] = {"백향목", "김동진", "김태원", "임재민", "김도형", "석주영", "장홍석", "김해든"};
    GridView gridView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_grid);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);

        gridView = (GridView) findViewById(R.id.gridView);

        gridView.setAdapter(adapter);

    }
}



