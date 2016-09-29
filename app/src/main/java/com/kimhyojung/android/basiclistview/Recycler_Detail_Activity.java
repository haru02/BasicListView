package com.kimhyojung.android.basiclistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Recycler_Detail_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler__detail_);

        Intent intent = getIntent();
        int position = intent.getExtras().getInt("position");  //리스트 데이터의 키값

        if(RecyclerActivity.datas != null) {
            RecyclerData data = RecyclerActivity.datas.get(position);

            ImageView iv = (ImageView) findViewById(R.id.ld_picture);
            iv.setBackgroundResource(data.image);
            TextView tv1 = (TextView) findViewById(R.id.textView20);
            tv1.setText(data.title);
            TextView tv2 = (TextView) findViewById(R.id.textView21);
            tv2.setText(data.name);
        }
    }
}
