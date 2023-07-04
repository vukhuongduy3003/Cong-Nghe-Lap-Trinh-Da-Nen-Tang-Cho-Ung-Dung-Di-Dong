package vn.com.a04_vukhuongduy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActivityWork extends AppCompatActivity {

    private Button btnThucHien, btnThoat;
    private RadioButton radioButton, radioButton2, radioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        btnThucHien = findViewById(R.id.btnThucHien);
        btnThoat = findViewById(R.id.btnThoat);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);

        btnThucHien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton.isChecked()) {
                    Toast.makeText(ActivityWork.this, "Không có công việc này", Toast.LENGTH_SHORT).show();
                }

                if (radioButton2.isChecked()) {
                    Intent intent = new Intent(ActivityWork.this, ActivityA.class);
                    startActivity(intent);
                }

                if (radioButton3.isChecked()) {
                    Toast.makeText(ActivityWork.this, "Không có công việc này", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityWork.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}