package com.programminghero.courseapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.programminghero.courseapp.R;
import com.programminghero.courseapp.model.PlayListModelClass;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    Context context;
    private ArrayList<PlayListModelClass> bonusModelArrayList;
    int myPos = 0;

    public RecycleAdapter(Context context, ArrayList<PlayListModelClass> bonusModelArrayList) {
        this.context = context;
        this.bonusModelArrayList = bonusModelArrayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvNumber, tvTime;
        ImageView ivGraph;

        public MyViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.playerTitle);
            tvNumber = view.findViewById(R.id.playerNumber);
            tvTime = view.findViewById(R.id.playTime);
            ivGraph = view.findViewById(R.id.ivGraph);
        }
    }

    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_play_list, parent, false);
        return new RecycleAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        PlayListModelClass lists = bonusModelArrayList.get(position);

        holder.tvTitle.setText(lists.getTitle());
        holder.tvNumber.setText(lists.getNumber());
        holder.tvTime.setText(lists.getTime());

        if (myPos == position) {
            holder.ivGraph.setVisibility(View.VISIBLE);
            holder.tvTitle.setTextColor(ContextCompat.getColor(context, R.color.blue));
            holder.tvNumber.setTextColor(ContextCompat.getColor(context, R.color.blue));
            holder.tvTime.setTextColor(ContextCompat.getColor(context, R.color.blue));
        } else {
            holder.ivGraph.setVisibility(View.GONE);
            holder.tvTitle.setTextColor(ContextCompat.getColor(context, R.color.black));
            holder.tvNumber.setTextColor(ContextCompat.getColor(context, R.color.dark_gray));
            holder.tvTime.setTextColor(ContextCompat.getColor(context, R.color.dark_gray));

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPos = position;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return bonusModelArrayList.size();
    }
}
