package com.uhackathon.momo.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.uhackathon.momo.R;
import com.uhackathon.momo.ui.login.LoginActivity;

public class SpalshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        ImageView gif_image = (ImageView) findViewById(R.id.gif_image);
        Glide.with(this).load(R.drawable.motion_splash).into(gif_image);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main = new Intent(SpalshActivity.this, LoginActivity.class);
                startActivity(main);
                finish();
            }
        }, 7200); // 3초 후(3000) 스플래시 화면을 닫습니다 (보통 사용하는 시간)
    }
}