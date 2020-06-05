package com.example.nesteddemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Normal2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<String> datas;
    public static final int TYPE_NORMAL = 2;
    public static final int TYPE_RECYCLERVIEW = 3;  //子Recyclerview
    private Context context;

    public Normal2Adapter(List<String> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }


    @Override
    public int getItemViewType(int position) {
        if (TextUtils.equals("recycler",datas.get(position))) {
            return TYPE_RECYCLERVIEW;
        }
        return TYPE_NORMAL;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_NORMAL:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
                break;
            case TYPE_RECYCLERVIEW:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_recyclerview, viewGroup, false);
                RecyViewHolder recyViewHolder = new RecyViewHolder(view);
                return recyViewHolder;
            default:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
                break;
        }

        NormalViewHolder vh = new NormalViewHolder(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == TYPE_NORMAL) {
            if (viewHolder instanceof NormalViewHolder) {
                NormalViewHolder normalViewHolder = (NormalViewHolder) viewHolder;
                normalViewHolder.mTextView.setText(datas.get(i));
            }

        } else if (getItemViewType(i) == TYPE_RECYCLERVIEW) {
            if (viewHolder instanceof RecyViewHolder) {
                RecyViewHolder recyViewHolder = (RecyViewHolder) viewHolder;
            }
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class NormalViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public NormalViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextView = itemView.findViewById(R.id.tv_index);

        }
    }

    public class RecyViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView recyclerView;

        public RecyViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.childRecycleView);
            recyclerView.setNestedScrollingEnabled(false);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            List<String> list = new ArrayList<>();
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591281583977&di=bcf7df3f2bc472d3272a85feaaeb2c55&imgtype=0&src=http%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F01%2F3e%2F05%2F40%2Fthe-sandbar-that-links.jpg");
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591281583977&di=bcf7df3f2bc472d3272a85feaaeb2c55&imgtype=0&src=http%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F01%2F3e%2F05%2F40%2Fthe-sandbar-that-links.jpg");
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591281583977&di=bcf7df3f2bc472d3272a85feaaeb2c55&imgtype=0&src=http%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F01%2F3e%2F05%2F40%2Fthe-sandbar-that-links.jpg");
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591281583977&di=bcf7df3f2bc472d3272a85feaaeb2c55&imgtype=0&src=http%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F01%2F3e%2F05%2F40%2Fthe-sandbar-that-links.jpg");
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591281583977&di=bcf7df3f2bc472d3272a85feaaeb2c55&imgtype=0&src=http%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F01%2F3e%2F05%2F40%2Fthe-sandbar-that-links.jpg");
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591281583977&di=bcf7df3f2bc472d3272a85feaaeb2c55&imgtype=0&src=http%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F01%2F3e%2F05%2F40%2Fthe-sandbar-that-links.jpg");
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591281583977&di=bcf7df3f2bc472d3272a85feaaeb2c55&imgtype=0&src=http%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F01%2F3e%2F05%2F40%2Fthe-sandbar-that-links.jpg");
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591281583977&di=bcf7df3f2bc472d3272a85feaaeb2c55&imgtype=0&src=http%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F01%2F3e%2F05%2F40%2Fthe-sandbar-that-links.jpg");
            list.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1913214116,3912663704&fm=26&gp=0.jpg");
            GridAdapter gridAdapter = new GridAdapter(context,list);
            recyclerView.setAdapter(gridAdapter);
        }
    }
}
