package com.icanerdogan.appvideogamesjavav1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.icanerdogan.appvideogamesjavav1.R;
import com.icanerdogan.appvideogamesjavav1.model.BaseModel;
import com.icanerdogan.appvideogamesjavav1.model.GameModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder> {
    private ArrayList<GameModel> gameModelList;

    public RecyclerViewAdapter(ArrayList<GameModel> gameModelList) {
        this.gameModelList = gameModelList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);

        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RowHolder holder, int position) {
        holder.bind(gameModelList.get(position),position);
        Picasso.get().load(gameModelList.get(position).getGame_image()).into(holder.gameBackgroundImage);
    }

    @Override
    public int getItemCount() { // Kaç Tane Row Oluşturulacak
        return gameModelList.size();
    }


    public class RowHolder extends RecyclerView.ViewHolder{
        TextView gameNameText;
        TextView gameRatingText;
        TextView gameReleasedText;
        ImageView gameBackgroundImage;

        public RowHolder(@NonNull View itemView) { super(itemView); }

        public void bind(GameModel model, Integer position){
            gameNameText = itemView.findViewById(R.id.gameName);
            gameRatingText = itemView.findViewById(R.id.gameRating);
            gameReleasedText = itemView.findViewById(R.id.gameReleased);
            gameBackgroundImage = itemView.findViewById(R.id.gameImage);

            gameNameText.setText(model.getGame_name());
            gameRatingText.setText(Double.toString(model.getGame_rating()));
            gameReleasedText.setText(model.getGame_released());
        }
    }
}
