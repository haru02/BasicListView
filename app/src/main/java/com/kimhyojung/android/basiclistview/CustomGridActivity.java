package com.kimhyojung.android.basiclistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomGridActivity extends AppCompatActivity {

    ArrayList<GridItem> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid);

        for(int i=0;i<100;i++){
            GridItem item = new GridItem();
            item.title = "Bang!";
            item.num = i;
            datas.add(item);
        }

        GridView gridView = (GridView) findViewById(R.id.gridView2);
        CustomGridAdapter cga = new CustomGridAdapter(this, datas, R.layout.activity_custom_list_griditem);
        gridView.setAdapter(cga);
    }
}

class GridItem{
    String title;
    int num;
}