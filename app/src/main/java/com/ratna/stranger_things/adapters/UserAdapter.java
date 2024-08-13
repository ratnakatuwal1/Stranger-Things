package com.ratna.stranger_things.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ratna.stranger_things.DetailActivity;
import com.ratna.stranger_things.R;
import com.ratna.stranger_things.datas.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    Context context;
    List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_characters, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.userName.setText(user.getName());
        holder.userActor.setText("By: "+user.getPortrayedBy());

        if(user.getPhoto().equalsIgnoreCase("unknown")){
            holder.userImage.setImageResource(R.drawable.runaway);
        }
        else{
            Glide.with(context).load(user.getPhoto()).into(holder.userImage);
        }

        //   holder.userImage.setImageResource(user.getImageResId());

        holder.moreButton.setOnClickListener(v -> {

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("user", user);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView userImage;
        TextView userName;
        TextView userActor;
        Button moreButton;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.imgCharacter);
            userName = itemView.findViewById(R.id.character);
            userActor = itemView.findViewById(R.id.actor);
            moreButton = itemView.findViewById(R.id.btnMore);
        }
    }
}