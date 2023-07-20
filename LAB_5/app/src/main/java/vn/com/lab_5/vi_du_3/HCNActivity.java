package vn.com.lab_5.vi_du_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vn.com.lab_5.R;

public class HCNActivity extends Activity implements View.OnClickListener {
    public static final int CHUVI = 1;
    public static final int DIENTICH = 2;
    public static final int HINHCHUNHAT = 1;
    private EditText etA, etB;
    private TextView tvResult;
    private Button hinhchunhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hcnactivity);
        etA = (EditText) findViewById(R.id.etA);
        etB = (EditText) findViewById(R.id.etB);
        tvResult = (TextView) findViewById(R.id.tvResult);
        hinhchunhat = (Button) findViewById(R.id.btChuNhat);
        hinhchunhat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(HCNActivity.this, XulyHCNactivity.class);
        int a = Integer.valueOf(etA.getText().toString());
        int b = Integer.valueOf(etB.getText().toString());
        Bundle bundle = new Bundle();
        bundle.putInt("CanhDai", a);
        bundle.putInt("CanhRong", b);
        intent.putExtra("GoiTin", bundle);
        startActivityForResult(intent, HINHCHUNHAT);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        if (requestCode == HINHCHUNHAT) {
            Bundle bundle = data.getBundleExtra("TapTin");
            int kq = bundle.getInt("KetQua");
            if (resultCode == CHUVI) {
                tvResult.setText("Chu vi hình Chữ nhật là: " + kq);
            }
            if (resultCode == DIENTICH) {
                tvResult.setText("Diện tích hình Chữ nhật là: " + kq);
            }
        }
    }
}
