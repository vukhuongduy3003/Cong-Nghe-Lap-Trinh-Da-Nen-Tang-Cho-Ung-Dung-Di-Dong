package vn.com.lab_5.vi_du_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vn.com.lab_5.R;

public class XulyHCNactivity extends Activity implements View.OnClickListener {
    private Button chuvi, dientich;
    private int a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuly_hcnactivity);
        final TextView textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("GoiTin");
        a = bundle.getInt("CanhDai");
        b = bundle.getInt("CanhRong");
        textView.setText("Đã nhận được dữ liệu " + a + " và " + b);
        chuvi = (Button) findViewById(R.id.btChuVi);
        chuvi.setOnClickListener(this);
        dientich = (Button) findViewById(R.id.btDienTich);
        dientich.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == chuvi) {
            sendToMain(2 * (a + b), HCNActivity.CHUVI);
        }
        if (v == dientich) {
            sendToMain((a * b), HCNActivity.DIENTICH);
        }
    }

    public void sendToMain(int value, int resultcode) {
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putInt("KetQua", value);
        intent.putExtra("TapTin", bundle);
        setResult(resultcode, intent);
        finish();
    }
}