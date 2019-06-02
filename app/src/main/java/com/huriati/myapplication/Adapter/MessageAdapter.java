package com.huriati.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.huriati.myapplication.MessagingActivity;
import com.huriati.myapplication.R;
import com.huriati.myapplication.model.Chats;
import com.huriati.myapplication.model.Chats;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    public static final int MSG_TYPE_LEFT = 0;
    public static final int MSG_TYPE_RIGHT = 1;

    FirebaseUser firebaseUser;
    private Context context;
    private List<Chats> listChats;

    public MessageAdapter(Context context, List<Chats> listChats) {
        this.context = context;
        this.listChats = listChats;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i == MSG_TYPE_RIGHT) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_right, viewGroup, false);
            return new MessageAdapter.ViewHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_left, viewGroup, false);
            return new MessageAdapter.ViewHolder(view);
        }
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Chats chats = listChats.get(i);
        viewHolder.show_msg.setText(chats.getMessage());
    }

    @Override
    public int getItemCount() {
        return listChats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView show_msg;

        public ViewHolder(View itemView){
            super(itemView);
            show_msg = itemView.findViewById(R.id.show_message);
        }
    }

    @Override
    public int getItemViewType(int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(listChats.get(position).getSender().equals(firebaseUser.getUid())){
            return MSG_TYPE_RIGHT;
        }else {
            return MSG_TYPE_LEFT;
        }
    }
}
