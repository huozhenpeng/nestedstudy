package com.example.nesteddemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by lihongxin on 2019/1/22
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    private List<String> datas;
    private Context context;

    public GridAdapter(Context context, List<String> datas) {
        this.context =context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pic_item, viewGroup, false);
        GridAdapter.ViewHolder vh = new GridAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.ViewHolder viewHolder, int i) {
        String text = datas.get(i);
        Glide.with(context).load(text).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }


}
