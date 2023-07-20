package com.example.vidu1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText edtUser,edtPass;
Button btnDangNhap,btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Dang nhap");
        edtUser=findViewById(R.id.edtUser);
        edtPass=findViewById(R.id.edtPass);
        btnDangNhap=findViewById(R.id.btnDangNhap);
        btnThoat=findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String matkhau=edtUser.getText().toString();
                String pass=edtPass.getText().toString();
                if (matkhau.equals("admin") && pass.equals("admin"))
                {
                    Intent intent=new Intent(MainActivity.this,DanhBaActivity.class);
                    startActivity(intent);
                }
                else Toast.makeText(MainActivity.this,"Tai khoan khong hop le",Toast.LENGTH_LONG).show();
            }
        });


    }
}