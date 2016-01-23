package com.example.tacademy.chattingct;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-01-23.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    int type;
    List<ChattingData> items = new ArrayList<ChattingData>();

    public static final int TYPE_RECEIVE = 0;
    public static final int TYPE_SEND = 1;

    public void add (ChattingData data) {
        items.add(data);
        notifyDataSetChanged();
    }

    private static final int VIEW_TYPE_SEND = 0;
    private static final int VIEW_TYPE_RECEIVE = 1;

    @Override
    public int getItemViewType(int position) {
        ChattingData data = items.get(position);
            if (data instanceof SendData) {
                return VIEW_TYPE_SEND;
            } else {
                return VIEW_TYPE_RECEIVE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        switch (viewType) {
            case VIEW_TYPE_SEND :
                view = inflater.inflate(R.layout.view_send, parent, false);
            return new SendViewHolder(view);
            case VIEW_TYPE_RECEIVE :
                view = inflater.inflate(R.layout.view_receive, parent, false);
                return new ReceiveViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_SEND :
                ((SendViewHolder)holder).setMyData((SendData) items.get(position));
                break;
            case VIEW_TYPE_RECEIVE :
                ((ReceiveViewHolder)holder).setMyData((ReceiveData) items.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
