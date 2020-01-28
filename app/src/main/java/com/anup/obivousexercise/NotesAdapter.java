package com.anup.obivousexercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder>{

    private ArrayList<DataModel> list;
    public NotesAdapter(ArrayList<DataModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notes_cardview, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataModel notesModel = list.get(position);
        holder.title.setText(notesModel.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }
}
