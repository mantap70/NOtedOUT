package com.mantao.notedout;

import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                EdgeToEdge.enable(this);
                setContentView(R.layout.activity_main);

                View content = findViewById(R.id.main_container);
                View bottomNav = findViewById(R.id.bottom_nav);

                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_container), (v, insets) -> {
                        Insets bar = insets.getInsets(WindowInsetsCompat.Type.systemBars());

                        content.setPadding(16, bar.top + 16, 16, bar.bottom + 16);
                        bottomNav.setPadding(0, 0, 0, bar.bottom);

                        return insets;
                });

                ImageView btnFav = findViewById(R.id.btn_fav);

                btnFav.setOnClickListener(v -> {
                        Intent intent = new Intent(MainActivity.this, FavActivity.class);
                        startActivity(intent);
                });

                ImageView btnAdd = findViewById(R.id.btn_add);

                btnAdd.setOnClickListener(v -> {
                        Intent intent = new Intent(this, AddNoteActivity.class);
                        startActivity(intent);
                });
                findViewById(R.id.btn_folder).setOnClickListener(v ->
                        startActivity(new Intent(this, FolderActivity.class)));



        }

        private void comingSoon(View v) {
                Toast.makeText(this, "Coming Soon 🚧", Toast.LENGTH_SHORT).show();

                findViewById(R.id.viewMoreNotes).setOnClickListener(this::comingSoon);
                findViewById(R.id.moreTools).setOnClickListener(this::comingSoon);
                findViewById(R.id.upload).setOnClickListener(this::comingSoon);
                findViewById(R.id.mail).setOnClickListener(this::comingSoon);
                findViewById(R.id.messageHome).setOnClickListener(this::comingSoon);
                findViewById(R.id.arrowLeft).setOnClickListener(this::comingSoon);
                findViewById(R.id.arrowRight).setOnClickListener(this::comingSoon);
                findViewById(R.id.ExploreMore).setOnClickListener(this::comingSoon);
        }

}
