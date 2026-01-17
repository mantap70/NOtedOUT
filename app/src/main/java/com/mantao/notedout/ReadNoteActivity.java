package com.mantao.notedout;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReadNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_note);

        TextView txtTitle = findViewById(R.id.txtTitle);
        TextView txtContent = findViewById(R.id.txtContent);

        txtTitle.setText(getIntent().getStringExtra("title"));
        txtContent.setText(getIntent().getStringExtra("content"));
    }
}