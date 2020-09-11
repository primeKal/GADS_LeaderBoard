package com.kalu.gadsleaderboard.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kalu.gadsleaderboard.Models.Users;
import com.kalu.gadsleaderboard.R;

import java.util.List;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.ViewHolder> {
    Context kContext;
    List<Users> kUsers;
    boolean kFlag;

    public UsersRecyclerAdapter(Context context, List<Users> users, boolean flag) {
        kContext = context;
        kUsers = users;
        kFlag=flag;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(kContext).inflate(R.layout.user_recycler_item_learning,parent,false);
        ViewHolder myViewHolder=new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.kname.setText(kUsers.get(position).getName());
        String extras=null;
        if(kFlag){
         extras= kUsers.get(position).getHours()+
                " learning hours," +
                kUsers.get(position).getCountry();}
        else  {
            extras=kUsers.get(position).getScore()+
                    " Skill score, " +
            kUsers.get(position).getCountry();
        }
        holder.kextradata.setText(extras);
        Glide.with(kContext).load(kUsers.get(position).getBadgeUrl()).into(holder.kIMage);

    }

    @Override
    public int getItemCount() {
        return kUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView kIMage;
        TextView kname;
        TextView kextradata;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            kname=itemView.findViewById(R.id.text_name);
            kIMage=itemView.findViewById(R.id.imageView);
            kextradata=itemView.findViewById(R.id.text_extra);
        }
    }
}
