package com.example.btl_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class RoomDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);

        Button btnBookNow = findViewById(R.id.btnBookNow);
        btnBookNow.setOnClickListener(v -> {
            startActivity(new Intent(RoomDetailActivity.this, BookingActivity.class));
        });

        findViewById(R.id.tvRoomName).setOnClickListener(v -> finish());
    }
}
