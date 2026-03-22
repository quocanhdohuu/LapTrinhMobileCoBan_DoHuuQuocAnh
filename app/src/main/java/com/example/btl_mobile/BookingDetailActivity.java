package com.example.btl_mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BookingDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_detail);

        TextView tvBack = findViewById(R.id.tvBack);
        Button btnCancel = findViewById(R.id.btnCancelBooking);

        tvBack.setOnClickListener(v -> finish());

        btnCancel.setOnClickListener(v -> {
            Toast.makeText(this, "Đã gửi yêu cầu huỷ phòng", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
