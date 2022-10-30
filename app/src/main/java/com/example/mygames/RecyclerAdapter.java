package com.example.mygames;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private final ArrayList<Games> games;
    private final LayoutInflater inflater;

    public RecyclerAdapter(Context context, ArrayList<Games> games) {
        this.inflater = LayoutInflater.from(context);
        this.games = games;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_game, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Games game = games.get(position);
        holder.txtTitle.setText(game.getTitle());
        holder.txtGenre.setText(game.getGenre());
        holder.txtDeveloper.setText(game.getDeveloper());

        Picasso.get().load(game.getThumbnail()).into(holder.imgThumbnail);

    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtGenre, txtPlatform, txtDeveloper;
        ImageView imgThumbnail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtGenre = itemView.findViewById(R.id.txt_genre);
            txtDeveloper = itemView.findViewById(R.id.txt_developer);
            imgThumbnail = itemView.findViewById(R.id.img_thumbnail);
        }
    }
}
