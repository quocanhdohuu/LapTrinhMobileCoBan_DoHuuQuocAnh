package com.example.btl_datphongkhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_datphongkhachsan.models.RoomType;

import java.util.Locale;

public class RoomDetailsActivity extends AppCompatActivity {

    private ImageView ivRoomDetail;
    private TextView tvRoomTitle, tvPrice, tvPriceBottom, tvRoomDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details);

        // Ánh xạ các view
        ivRoomDetail = findViewById(R.id.ivRoomDetail);
        tvRoomTitle = findViewById(R.id.tvRoomTitle);
        tvPrice = findViewById(R.id.tvPrice);
        tvPriceBottom = findViewById(R.id.tvPriceBottom);
        tvRoomDesc = findViewById(R.id.tvRoomDesc);

        // Lấy dữ liệu từ Intent
        RoomType roomType = (RoomType) getIntent().getSerializableExtra("ROOM_TYPE");

        if (roomType != null) {
            // Hiển thị dữ liệu
            tvRoomTitle.setText(roomType.getName());
            String priceStr = String.format(Locale.getDefault(), "%,.0f VNĐ", roomType.getDefaultPrice());
            tvPrice.setText(priceStr);
            tvPriceBottom.setText(priceStr + " / đêm");
            tvRoomDesc.setText(roomType.getDescription());
            
            // Vì chưa có URL ảnh từ API nên hiện tại dùng ảnh mặc định, 
            // Nếu sau này có URL ảnh, bạn có thể dùng Glide để load:
            // Glide.with(this).load(roomType.getImageUrl()).into(ivRoomDetail);
        }

        Button btnBook = findViewById(R.id.btnBookThisSuite);
        if (btnBook != null) {
            btnBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RoomDetailsActivity.this, BookingConfirmActivity.class);
                    startActivity(intent);
                }
            });
        }

        View btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}