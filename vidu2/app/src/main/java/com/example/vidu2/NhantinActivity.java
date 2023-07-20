package com.example.vidu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class NhantinActivity extends AppCompatActivity {
    ImageButton imgNhan;
    EditText edtGoi;
    Button btnTroVe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhantin);
        this.setTitle("Nhan tin");
        edtGoi=findViewById(R.id.edtSoDienThoai_Nhan);
        imgNhan=findViewById(R.id.imgNhanTin_Nhan);
        btnTroVe=findViewById(R.id.btnTroVe_Nhan);
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        imgNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtGoi.getText().toString().equals(""))
                    Toast.makeText(NhantinActivity.this,"Chua chon so",Toast.LENGTH_LONG).show();
                else
                {
                    Intent intent=new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+edtGoi.getText().toString()));
                    startActivity(intent);
                }
            }
        });
    }
}