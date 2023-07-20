package vn.com.lab_5.vi_du_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.com.lab_5.R;

public class MainActivity extends AppCompatActivity {
    Button btnHCN, btnHV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btnHCN = (Button) findViewById(R.id.btnhcn);
        btnHV = (Button) findViewById(R.id.btnhv);
        btnHCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HCNActivity.class);
                startActivity(intent);
            }
        });
        btnHV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HVActivity.class);
                startActivity(intent);
            }
        });
    }
}