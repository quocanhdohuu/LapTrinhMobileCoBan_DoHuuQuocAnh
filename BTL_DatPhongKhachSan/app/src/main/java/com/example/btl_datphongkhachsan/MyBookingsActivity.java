package com.example.btl_datphongkhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MyBookingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);

        // Điều hướng Bottom Navigation
        findViewById(R.id.llNavHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyBookingsActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        findViewById(R.id.llNavProfile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyBookingsActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}