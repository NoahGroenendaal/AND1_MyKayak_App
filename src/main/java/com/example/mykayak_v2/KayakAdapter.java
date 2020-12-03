package com.example.mykayak_v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KayakAdapter extends RecyclerView.Adapter<KayakAdapter.ViewHolder> {

    List<Kayaks> kayaks;
    OnListItemClickListener listener;

    public KayakAdapter(List<Kayaks> Kayaks, OnListItemClickListener listener){
        this.kayaks = Kayaks;
        this.listener = listener;
    }

    @NonNull
    @Override
    public KayakAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.kayak_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KayakAdapter.ViewHolder holder, int position) {
        holder.kayakname.setText(kayaks.get(position).getName());
        holder.kayaklogo.setImageResource(kayaks.get(position).getLogo());
    }

    @Override
    public int getItemCount() {
        return kayaks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView kayakname;
        ImageView kayaklogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(getAdapterPosition());
                }
            });
            kayakname = itemView.findViewById(R.id.kayak_name);
            kayaklogo = itemView.findViewById(R.id.kayak_logo);

        }
    }
    public interface OnListItemClickListener {
        void onClick(int position);
    }

}
