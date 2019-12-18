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

public class GymItemSelectedAdapter extends RecyclerView.Adapter<GymItemSelectedAdapter.GymItemSelectedViewHolder>{
    private List<GymItem> gymItemSelectedList;
    private GymItemSelectedDelgate gymItemSelectedDelgate;

    public GymItemSelectedAdapter(List<GymItem> gymItemList, GymItemSelectedDelgate gymItemSelectedDelgate) {
        this.gymItemSelectedList = gymItemList;
        this.gymItemSelectedDelgate = gymItemSelectedDelgate;
    }

    public interface GymItemSelectedDelgate{
        void viewGymItemSelected(GymItem gymItem);
        void deleteGymItem(GymItem gymItem);
    }

    @NonNull
    @Override
    public GymItemSelectedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gym_item_selected_layout, parent, false);

        return new GymItemSelectedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GymItemSelectedViewHolder holder, int position) {
        holder.gymItemSelectedNameTextView.setText(gymItemSelectedList.get(position).getGymItemName());
        holder.gymItemSelectedQuantityTextView.setText(gymItemSelectedList.get(position).getGymItemQuantity());

    }

    @Override
    public int getItemCount() {
        return gymItemSelectedList.size();
    }




    class GymItemSelectedViewHolder extends RecyclerView.ViewHolder{

        TextView gymItemSelectedNameTextView;
        TextView gymItemSelectedQuantityTextView;

        public GymItemSelectedViewHolder(@NonNull View itemView) {
            super(itemView);
            gymItemSelectedNameTextView = itemView.findViewById(R.id.gym_item_name_selected_textview);
            gymItemSelectedQuantityTextView = itemView.findViewById(R.id.gym_item_selected_quantity_textview);

        }
    }
}
