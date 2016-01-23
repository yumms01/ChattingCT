package com.example.tacademy.chattingct;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tacademy on 2016-01-23.
 */
public class SendViewHolder extends RecyclerView.ViewHolder {

    SendData data;
    ImageView iconView;
    TextView messageView;
    TextView timeText;

    public SendViewHolder(View itemView) {
        super(itemView);
        iconView = (ImageView)itemView.findViewById(R.id.image_icon);
        messageView = (TextView)itemView.findViewById(R.id.text_message);
        timeText = (TextView)itemView.findViewById(R.id.text_time);
    }

    public void setMyData(SendData data) {
        this.data = data;
        messageView.setText(data.message);
        iconView.setImageResource(data.iconId);
        timeText.setText(data.date);
    }

}
