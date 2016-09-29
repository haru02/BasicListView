package com.kimhyojung.android.basiclistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class RecyclerCardActivity extends AppCompatActivity {

    public static ArrayList<RecyclerData> datas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_card);

        datas = new ArrayList<>();

        for(int i=0;i<100;i++){
            RecyclerData data = new RecyclerData();

            data.title = i+" Rolling in the deep";
            data.name = "pichachu";
            data.image = R.mipmap.pikachu2;
            datas.add(data);
        }
        RecyclerView cardView = (RecyclerView) findViewById(R.id.recyclerCardView);
        RecyclerCardAdapter cardAdapter =  new RecyclerCardAdapter(datas, R.layout.activity_recycler_card_item, this);
        cardView.setAdapter(cardAdapter);
        //cardView.setLayoutManager(new LinearLayoutManager(this));

        /*
        // 수직 수평 스크롤이 가능
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        // 그리드 타입
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 3);
        // StaggererdGrid 타입 */
        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        cardView.setLayoutManager(manager);



    }
}
