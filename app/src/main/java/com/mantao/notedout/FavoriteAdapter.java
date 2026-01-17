package com.mantao.notedout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private final List<String> notesList;

    public FavoriteAdapter(List<String> notesList) {
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_favorite_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNoteTitle.setText(notesList.get(position));
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNoteTitle;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNoteTitle = itemView.findViewById(R.id.txtNoteTitle);
        }
    }
}