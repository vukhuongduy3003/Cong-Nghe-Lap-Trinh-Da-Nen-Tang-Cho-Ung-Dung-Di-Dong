package com.example.vidu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class GoiDienActivity extends AppCompatActivity {
ImageButton imgGoi;
EditText edtGoi;
Button btnTroVe;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goi_dien);
        this.setTitle("Goi dien");
        edtGoi=findViewById(R.id.edtSoDienThoai_Goi);
        imgGoi=findViewById(R.id.imgGoi_Goi);
        btnTroVe=findViewById(R.id.btnTroVe_Goi);
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        imgGoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtGoi.getText().toString().equals(""))
                    Toast.makeText(GoiDienActivity.this,"Chua chon so",Toast.LENGTH_LONG).show();
                else
                {
                    Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+edtGoi.getText().toString()));
                    startActivity(intent);
                }
            }
        });
    }
}