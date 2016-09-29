package com.kimhyojung.android.basiclistview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by USER on 2016-09-28.
 */
public class RecyclerCardAdapter extends RecyclerView.Adapter<RecyclerCardAdapter.ViewHolder>{

    ArrayList<RecyclerData> datas;
    int itemlayout;
    Context context;

    public RecyclerCardAdapter(ArrayList<RecyclerData> datas, int itemlayout, Context context){
        this.datas = datas;
        this.itemlayout = itemlayout;
        this.context = context;
    }

    // view를 만들어서 홀더에 저장한는 역할
    @Override
    public RecyclerCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemlayout, parent, false);
        return new ViewHolder(view);
    }

    // 일반 ListAdapter의 getView를 대체하는 역할
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        RecyclerData data = datas.get(position);
        holder.img.setBackgroundResource(data.image);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "이미지가 클릭됨", Toast.LENGTH_SHORT).show();
            }
            });

        holder.textTitle.setText(data.title);
        holder.itemView.setTag(data);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Recycler_Detail_Activity.class);
                intent.putExtra("position", position);

                context.startActivity(intent);
            }
        });
        setAnimation(holder.cardView, position);
    }

    int lastPosition = -1;
    public void setAnimation(View view, int position){
        if(position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            view.startAnimation(animation);
            lastPosition = position;
        }
    }

    //
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //데이터를 재사용해주는 객체
    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView textTitle;
        CardView cardView;

        public ViewHolder(View itemView){
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.image);
            textTitle = (TextView) itemView.findViewById(R.id.title);
            cardView = (CardView) itemView.findViewById(R.id.carditem);
        }
    }
}
