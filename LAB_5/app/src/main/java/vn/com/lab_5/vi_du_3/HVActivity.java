package vn.com.lab_5.vi_du_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vn.com.lab_5.R;

public class HVActivity extends AppCompatActivity {
    public static final int CHUVI = 1;
    public static final int DIENTICH = 2;
    public static final int HINHVUONG = 1;
    private EditText etA;
    private TextView tvResult;
    private Button btnhv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hvactivity);
        etA = (EditText) findViewById(R.id.etcanhA);
        tvResult = (TextView) findViewById(R.id.tvResult1);
        btnhv = findViewById(R.id.btnhvuong);
        btnhv.setOnClickListener((View.OnClickListener) this);
    }
    public void onClick(View v) {
        Intent intent = new Intent(HVActivity.this,XulyHVactivity.class);
        int a = Integer.valueOf(etA.getText().toString());
        Bundle bundle = new Bundle();
        bundle.putInt("Canh", a); // Canh là tên giao dịch
        intent.putExtra("GoiTin", bundle);
        startActivityForResult(intent, HINHVUONG);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (requestCode == HINHVUONG) {
            Bundle bundle = data.getBundleExtra("TapTin");
            int kq = bundle.getInt("KetQua");
            if (resultCode == CHUVI) {
                tvResult.setText("Chu vi hình vuông là: " + kq);
            }
            if (resultCode == DIENTICH) {
                tvResult.setText("Diện tích hình vuông là: " + kq);
            }
        }
    }
}