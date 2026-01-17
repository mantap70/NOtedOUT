package com.mantao.notedout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import java.util.Locale;


public class SplashActivity extends AppCompatActivity {

    private View whiteView;
    private RelativeLayout grayContainer;
    private ImageView logoCenter, logoFinal, flag;
    private TextView title, subtitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        whiteView       = findViewById(R.id.whiteView);
        grayContainer   = findViewById(R.id.grayContainer);

        logoCenter      = findViewById(R.id.logoCenter);
        logoFinal       = findViewById(R.id.logoFinal);
        title           = findViewById(R.id.title);
        subtitle        = findViewById(R.id.subtitle);
        flag            = findViewById(R.id.flag);

        // tambahkan setelah semua findViewById
        updateLocaleDisplay();

        startSequence();
    }


    // ====================================
    // ====== LOCALE DETECTOR ============
    // ====================================

    private void updateLocaleDisplay() {

        String countryCode = Locale.getDefault().getCountry();

        if(countryCode.equalsIgnoreCase("ID")) {
            // Indonesia
            title.setText("Selamat Datang");
            subtitle.setText("Klik untuk melanjutkan");
            flag.setImageResource(R.drawable.flag_indonesia);

        } else if(countryCode.equalsIgnoreCase("US")) {
            // USA
            title.setText("Welcome");
            subtitle.setText("Click to continue");
            flag.setImageResource(R.drawable.flag_us);

        } else if(countryCode.equalsIgnoreCase("JP")) {
            // Jepang
            title.setText("ようこそ");
            subtitle.setText("クリックして続行");
            flag.setImageResource(R.drawable.flag_jp);

        } else {
            // default kalau negara lain
            title.setText("Selamat Datang");
            subtitle.setText("Klik untuk melanjutkan");
            flag.setImageResource(R.drawable.flag_indonesia);
        }
    }



    // ====================================
    // ===== ANIMATION SEQUENCE ===========
    // ====================================

    private void startSequence() {
        logoCenter.setScaleX(0.4f);
        logoCenter.setScaleY(0.4f);
        logoCenter.setAlpha(0f);

        logoCenter.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(600)
                .setInterpolator(new DecelerateInterpolator())
                .withEndAction(() -> {

                    logoCenter.animate()
                            .scaleX(0.75f)
                            .scaleY(0.75f)
                            .setDuration(400)
                            .setStartDelay(200)
                            .withEndAction(this::showFinalScreen)
                            .start();
                })
                .start();
    }


    private void showFinalScreen() {
        grayContainer.setVisibility(View.VISIBLE);
        grayContainer.setAlpha(0f);
        grayContainer.animate().alpha(1f).setDuration(400).start();

        logoCenter.animate().alpha(0f).setDuration(300).start();

        fadeIn(logoFinal, 450, 200);
        fadeIn(title, 550, 350);
        fadeIn(subtitle, 650, 450);
        fadeIn(flag, 650, 450);

        grayContainer.setOnClickListener(v -> {
            Intent i = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        });
    }


    private void fadeIn(View v, long duration, long delay) {
        v.setAlpha(0f);
        v.animate().alpha(1f).setDuration(duration).setStartDelay(delay).start();
    }
}
