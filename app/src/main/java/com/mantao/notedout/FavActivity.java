package com.mantao.notedout;

import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        requestNotificationPermission();


        createNotificationChannel();

        // ❤️ icon aktif
        ImageView favIcon = findViewById(R.id.btn_fav);
        favIcon.setImageResource(R.drawable.filled_heart);

        // ⬅️ title ke home
        TextView title = findViewById(R.id.title_nav);
        title.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        });

        // ➕ add note
        findViewById(R.id.btn_add)
                .setOnClickListener(v ->
                        startActivity(new Intent(this, AddNoteActivity.class)));

        // 📁 ke folder
        findViewById(R.id.btn_folder)
                .setOnClickListener(v ->
                        startActivity(new Intent(this, FolderActivity.class)));

        RecyclerView rv = findViewById(R.id.rvFavorites);
        rv.setLayoutManager(new GridLayoutManager(this, 2));

        // 🔥 filter favorite
        List<Note> favorites = new ArrayList<>();
        for (Note n : NoteRepository.NOTES) {
            if (n.isFavorite) favorites.add(n);
        }

        FolderAdapter adapter = new FolderAdapter(this, favorites);
        rv.setAdapter(adapter);
    }

    private void requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(
                        this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS},
                        100
                );
            }
        }
    }


    // 🔔 Notification channel
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "favorite_channel",
                    "Favorite Notification",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("Notification for favorite notes");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    // 🔔 Show notification
    public void showFavoriteNotification() {
        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, "favorite_channel")
                        .setSmallIcon(android.R.drawable.btn_star_big_on)
                        .setContentTitle("Favorite")
                        .setContentText("Notes telah di Like ❤️")
                        .setAutoCancel(true);

        manager.notify((int) System.currentTimeMillis(), builder.build());
    }
}