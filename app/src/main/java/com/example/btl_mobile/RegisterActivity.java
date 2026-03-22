package com.example.btl_mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRegister = findViewById(R.id.btnRegister);
        TextView tvBackToLogin = findViewById(R.id.tvBackToLogin);

        btnRegister.setOnClickListener(v -> {
            Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
            finish();
        });

        tvBackToLogin.setOnClickListener(v -> finish());
    }
}
