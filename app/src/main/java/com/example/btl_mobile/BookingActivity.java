package com.example.btl_mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Button btnConfirm = findViewById(R.id.btnConfirmBooking);
        btnConfirm.setOnClickListener(v -> {
            Toast.makeText(this, "Đặt phòng thành công!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
