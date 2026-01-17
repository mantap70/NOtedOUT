package com.mantao.notedout;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ViewHolder> {

    Context context;
    List<Note> notes;

    public FolderAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_favorite_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int position) {
        Note note = notes.get(position);

        h.txtTitle.setText(note.title);

        // ❤️ status icon
        h.btnFavorite.setImageResource(
                note.isFavorite ? R.drawable.red_heart : R.drawable.favorite
        );

        // ❤️ toggle favorite
        h.btnFavorite.setOnClickListener(v -> {
            note.isFavorite = !note.isFavorite;
            notifyItemChanged(position);

            if (note.isFavorite) {
                // 🔔 PANGGIL NOTIFIKASI DENGAN AMAN
                if (context instanceof FavActivity) {
                    ((FavActivity) context).showFavoriteNotification();
                } else if (context instanceof FolderActivity) {
                    ((FolderActivity) context).showFavoriteNotification();
                }
            }
        });

        // 📖 baca note
        h.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, ReadNoteActivity.class);
            i.putExtra("title", note.title);
            i.putExtra("content", note.content);
            context.startActivity(i);
        });

        // ✏️ edit
        h.btnEdit.setOnClickListener(v -> {
            Intent i = new Intent(context, AddNoteActivity.class);
            i.putExtra("edit", true);
            i.putExtra("index", position);
            context.startActivity(i);
        });

        // 🗑 hapus
        h.btnDelete.setOnClickListener(v -> {
            notes.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, notes.size());
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, btnEdit;
        ImageView btnFavorite, btnDelete;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtNoteTitle);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnFavorite = itemView.findViewById(R.id.btnFavorite);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}