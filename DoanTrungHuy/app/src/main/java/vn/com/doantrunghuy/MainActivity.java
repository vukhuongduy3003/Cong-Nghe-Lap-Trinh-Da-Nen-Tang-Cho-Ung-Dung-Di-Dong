package vn.com.doantrunghuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtInputHoTen = findViewById(R.id.txtInputHoTen);
        TextView txtInputLop = findViewById(R.id.txtInputLop);
        Button btnThoat = findViewById(R.id.btnThoat);
        Button btnTiepTuc = findViewById(R.id.btnTiepTuc);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtInputHoTen.getText().toString().isEmpty() || txtInputLop.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông tin thì mới được tiếp tục", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}