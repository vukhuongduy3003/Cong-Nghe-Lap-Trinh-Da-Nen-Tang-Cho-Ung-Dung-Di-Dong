package com.example.dangnhap;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DangNhap extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnExit = findViewById(R.id.btnExit);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.equals("admin") && password.equals("admin")) {
                    Intent intent = new Intent(DangNhap.this, ThongTinSV.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(DangNhap.this, "Tên đăng nhập hoặc mật khẩu không đúng. Vui lòng nhập lại!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutoolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            Toast.makeText(this, "Item 1", Toast.LENGTH_LONG).show();
        } else if (id == R.id.item2) {
            Toast.makeText(this, "Item 2", Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.item3) {
            Toast.makeText(this, "Item 3", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}