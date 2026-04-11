package com.example.btl_datphongkhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookingConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirm);

        findViewById(R.id.btnConfirmBooking).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookingConfirmActivity.this, "Đặt phòng thành công!", Toast.LENGTH_SHORT).show();
                
                // Quay về trang chủ (HomeActivity)
                // FLAG_ACTIVITY_CLEAR_TOP giúp xóa các Activity nằm trên HomeActivity trong stack
                Intent intent = new Intent(BookingConfirmActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                
                // Kết thúc Activity hiện tại
                finish();
            }
        });
    }
}