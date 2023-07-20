package com.example.vidu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class DuyetWebActivity extends AppCompatActivity {
    ImageButton imgWeb;
    EditText edtDuyetWeb;
    Button btnTroVe;
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duyet_web);
        this.setTitle("Duyet web");
        edtDuyetWeb=findViewById(R.id.edtWeb_Web);
        imgWeb=findViewById(R.id.imgWeb_Web);
        btnTroVe=findViewById(R.id.btnTroVe_Web);
        wv = findViewById(R.id.wvDuyetWeb);
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        imgWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtDuyetWeb.getText().toString().equals(""))
                    Toast.makeText(DuyetWebActivity.this,"Chua co dia chi",Toast.LENGTH_LONG).show();
                else
                {
                    wv.loadUrl("http://www."+edtDuyetWeb.getText().toString().trim());
                }
            }
        });
    }
}