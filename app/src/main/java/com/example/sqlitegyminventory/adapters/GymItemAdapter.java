package com.example.sqlitegyminventory.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlitegyminventory.R;
import com.example.sqlitegyminventory.model.GymItem;

import java.util.List;

public class GymItemAdapter extends RecyclerView.Adapter<GymItemAdapter.GymItemViewHolder> {
    private List<String> gymItemList;
    private GymItemDelegate gymItemDelegate;

    public GymItemAdapter(List<String> gymItemList, GymItemDelegate gymItemDelegate) {
        this.gymItemList = gymItemList;
        this.gymItemDelegate = gymItemDelegate;
    }

    public interface GymItemDelegate{
        void deleteGymItem(GymItem gymItem);
        void viewGymItem(String string);

    }

    @NonNull
    @Override
    public GymItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gym_item_layout, parent, false);

        return new GymItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GymItemViewHolder holder, int position) {
        holder.gymItemTextView.setText(gymItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return gymItemList.size();
    }


    class GymItemViewHolder extends RecyclerView.ViewHolder{

        TextView gymItemTextView;

        public GymItemViewHolder(@NonNull View itemView) {
            super(itemView);
            gymItemTextView = itemView.findViewById(R.id.gym_item_info_textview);
        }
    }

}
