package vn.com.lab_5.bai_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.com.lab_5.R;

public class ActivityB extends AppCompatActivity {
    EditText edta1, edtb1, edtc1, edtkq;
    Button btchuyen1, bttinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        edta1 = findViewById(R.id.edta1);
        edtb1 = findViewById(R.id.edtb1);
        edtc1 = findViewById(R.id.edtc1);
        edtkq = findViewById(R.id.edtkq);
        btchuyen1 = findViewById(R.id.btchuyen1);
        bttinh = findViewById(R.id.bttinh);

        Intent intent = getIntent();
        final double a = intent.getDoubleExtra("numa", 0);
        final double b = intent.getDoubleExtra("numb", 0);
        final double c = intent.getDoubleExtra("numc", 0);
        edta1.setText(String.valueOf(a));
        edtb1.setText(String.valueOf(b));
        edtc1.setText(String.valueOf(c));
        btchuyen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }

        });
        bttinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinh(a, b, c);

            }
        });

    }

    private void back() {

        if (!edtkq.getText().toString().equals("")) {
            Intent intent = new Intent(ActivityB.this, ActivityA.class);
            double kq = Double.parseDouble(edtkq.getText().toString());
            intent.putExtra("result", kq);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            Toast.makeText(this, "Không có kết quả để gửi lại", Toast.LENGTH_SHORT).show();
        }
    }

    private void tinh(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        double x1, x2;
        if (delta > 0) {
            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);
            edtkq.setText("Phương trình 2 nghiệm phân biệt " + x1 + " Và " + x2);
            Toast.makeText(this, "Phương trình 2 nghiệm phân biệt " + x1 + " Và " + x2, Toast.LENGTH_LONG).show();
        } else if (delta == 0) {
            double x = -b / (2 * a);
            edtkq.setText("Phương trình 2 nghiệm kép " + x);
            Toast.makeText(this, "Phương trình 2 nghiệm kép " + x, Toast.LENGTH_LONG).show();
        } else {
            edtkq.setText("Phương trình vô nghiệm");
            Toast.makeText(this, "Phương trình vô nghiệm", Toast.LENGTH_SHORT).show();
        }
    }
}