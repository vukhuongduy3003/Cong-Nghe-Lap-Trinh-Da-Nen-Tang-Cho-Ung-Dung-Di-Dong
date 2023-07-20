package vn.com.lab_5.bai_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.com.lab_5.R;

public class ActivityB extends AppCompatActivity {
    EditText edtaa, edtbb, edtkqq;
    Button btgpt, btveaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_activity_b);
        edtaa = findViewById(R.id.edtaa);
        edtbb = findViewById(R.id.edtbb);
        btgpt = findViewById(R.id.btgpt);
        btveaca = findViewById(R.id.btveaca);
        edtkqq = findViewById(R.id.edtkqq);

        Intent intent = getIntent();
        final double a = intent.getDoubleExtra("numa", 0);
        final double b = intent.getDoubleExtra("numb", 0);

        edtaa.setText(String.valueOf(a));
        edtbb.setText(String.valueOf(b));

        btgpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinhq(a, b);
            }
        });
        btveaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
    }

    private void back() {

        if (!edtkqq.getText().toString().equals("")) {
            Intent intent = new Intent(ActivityB.this, ActivityA.class);
            double kq1 = Double.parseDouble(edtkqq.getText().toString());
            intent.putExtra("result", kq1);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            Toast.makeText(this, "Không có kết quả để gửi lại", Toast.LENGTH_SHORT).show();
        }
    }

    private void tinhq(double a, double b) {
        double x;
        if (a != 0) {
            x = -b / a;
            edtkqq.setText("Phương trình có nghiệm " + x);
        } else {

            edtkqq.setText("Phương trình vô số nghiệm");
        }
    }
}