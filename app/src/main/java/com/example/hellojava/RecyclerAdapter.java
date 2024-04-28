package com.example.hellojava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.GridItemViewHolder> {
    private Context context;
    private List<Item> ItemList;





    public RecyclerAdapter(List<Item> ItemList) {
        this.ItemList = ItemList;
    }

    @Override
    public GridItemViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new GridItemViewHolder(itemView, this);
    }


    @Override
    public void onBindViewHolder(GridItemViewHolder holder, int position) {
        Item items = ItemList.get(position);
        holder.mName.setText(items.getName());
        holder.mID.setText("" + items.getId());
        holder.mRegistrationDate.setText("" + items.getRegistrationDate());
    }

    @Override
    public int getItemCount() {
        return ItemList.size();
    }







    public class GridItemViewHolder extends RecyclerView.ViewHolder {
        public TextView mName, mID, mRegistrationDate;
        public RecyclerAdapter mAdapter;

        public GridItemViewHolder(View itemView, RecyclerAdapter mAdapter) {
            super(itemView);
            this.mAdapter = mAdapter;
            mName = (TextView) itemView.findViewById(R.id.name);
            mID = (TextView) itemView.findViewById(R.id.companyName);
            mRegistrationDate = (TextView) itemView.findViewById(R.id.registrationDate);

        }




    }
}

