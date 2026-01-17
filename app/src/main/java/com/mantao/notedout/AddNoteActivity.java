package com.mantao.notedout;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    private boolean isFavorite = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        EditText edtTitle = findViewById(R.id.edt_title);
        EditText edtContent = findViewById(R.id.edt_content);
        ImageView btnSave = findViewById(R.id.btn_save);
        ImageView btnFavorite = findViewById(R.id.btn_favorite);

        btnFavorite.setOnClickListener(v -> {
            isFavorite = !isFavorite;
            btnFavorite.setImageResource(
                    isFavorite ? R.drawable.filled_heart : R.drawable.favorite
            );
        });

        btnSave.setOnClickListener(v -> {
            String title = edtTitle.getText().toString().trim();
            String content = edtContent.getText().toString().trim();

            if (title.isEmpty()) {
                Toast.makeText(this, "Title cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            Note note = new Note(title, content, isFavorite);
            NoteRepository.NOTES.add(note);

            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();
            finish(); // balik ke folder
        });

        boolean isEdit = getIntent().getBooleanExtra("edit", false);
        int index = getIntent().getIntExtra("index", -1);

        if (isEdit) {
            Note note = NoteRepository.NOTES.get(index);
            edtTitle.setText(note.title);
            edtContent.setText(note.content);
        }

        btnSave.setOnClickListener(v -> {
            if (isEdit) {
                Note note = NoteRepository.NOTES.get(index);
                note.title = edtTitle.getText().toString();
                note.content = edtContent.getText().toString();
            } else {
                NoteRepository.NOTES.add(
                        new Note(
                                edtTitle.getText().toString(),
                                edtContent.getText().toString(),
                                false
                        )
                );
            }
            finish();
        });

    }
}
