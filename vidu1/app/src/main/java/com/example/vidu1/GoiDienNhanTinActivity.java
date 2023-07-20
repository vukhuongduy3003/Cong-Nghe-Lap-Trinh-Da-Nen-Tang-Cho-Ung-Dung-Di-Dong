package com.example.vidu1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GoiDienNhanTinActivity extends AppCompatActivity {
EditText edtSdt;
Button btnGoi,btnNhan,btnTroVe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goi_dien_nhan_tin);
        this.setTitle("Goi dien, nhan tin");
        edtSdt=findViewById(R.id.edtGoiNhan);
        btnGoi=findViewById(R.id.btnGoi_GoiNhan);
        btnNhan=findViewById(R.id.btnNhan_GoiNhan);
        btnTroVe=findViewById(R.id.btnTroVe_GoiNhan);
        Intent intent=getIntent();
        edtSdt.setText(intent.getStringExtra("sdt"));
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnGoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+edtSdt.getText().toString()));
                startActivity(intent1);
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:"+edtSdt.getText().toString()));
                startActivity(intent2);
            }
        });
    }
}