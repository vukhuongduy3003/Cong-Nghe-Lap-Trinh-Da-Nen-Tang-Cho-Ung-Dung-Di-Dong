package com.example.dangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ThongTinSV extends AppCompatActivity {

    Button btnThoat, btnTiep, btnXacNhan;
    EditText etHoTen;
    RadioButton rbNam, rbNu;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_sv);

        btnThoat = findViewById(R.id.btnThoat);
        btnTiep = findViewById(R.id.btnTiep);
        btnXacNhan = findViewById(R.id.btnXacNhan);
        etHoTen = findViewById(R.id.etHoTen);
        rbNam = findViewById(R.id.rbNam);
        rbNu = findViewById(R.id.rbNu);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);

        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThongTinSV.this, ListMonAn.class);
                startActivity(intent);
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gioiTinh = rbNam.isChecked() ? "Nam" : "Nữ";
                String thongTin = "Họ tên: " + etHoTen.getText().toString() + ", giới tính: " + gioiTinh + ", sở thích: " + updateResult();
                Toast.makeText(ThongTinSV.this, thongTin, Toast.LENGTH_LONG).show();
            }
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateResult();
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateResult();
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateResult();
            }
        });
    }

    private String updateResult() {
        StringBuilder result = new StringBuilder();
        if (checkBox1.isChecked()) {
            result.append("Bóng đá, ");
        }
        if (checkBox2.isChecked()) {
            result.append("Cầu lông, ");
        }
        if (checkBox3.isChecked()) {
            result.append("Bóng chuyền, ");
        }
        if (checkBox4.isChecked()) {
            result.append("Bóng rổ, ");
        }
        return result.toString();
    }
}