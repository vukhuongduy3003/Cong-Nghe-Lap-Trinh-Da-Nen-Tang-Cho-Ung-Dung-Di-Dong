package vn.com.lab_5.bai_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.com.lab_5.R;

public class ActivityC extends AppCompatActivity {
    EditText edta2, edtb2, edttong, edthieu;
    Button bttinhc, btaca2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_activity_c);
        edta2 = findViewById(R.id.edta2);
        edtb2 = findViewById(R.id.edtb2);
        bttinhc = findViewById(R.id.bttinhc);
        btaca2 = findViewById(R.id.btaca2);
        edttong = findViewById(R.id.edttong);
        edthieu = findViewById(R.id.edthieu);

        Intent intent = getIntent();
        final double a = intent.getDoubleExtra("numa", 0);
        final double b = intent.getDoubleExtra("numb", 0);

        edta2.setText(String.valueOf(a));
        edtb2.setText(String.valueOf(b));

        bttinhc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinh2(a, b);
            }
        });
        btaca2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back1();
            }
        });
    }

    private void back1() {

        if (!edttong.getText().toString().equals("") || !edthieu.getText().toString().equals("")) {
            Intent intent = new Intent(ActivityC.this, ActivityA.class);
            double kqtong = Double.parseDouble(edttong.getText().toString());
            intent.putExtra("result", kqtong);
            double kqhieu = Double.parseDouble(edthieu.getText().toString());
            intent.putExtra("result", kqhieu);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            Toast.makeText(this, "Không có kết quả để gửi lại", Toast.LENGTH_SHORT).show();
        }
    }

    private void tinh2(double a, double b) {

        double q, p;
        q = a + b;
        edttong.setText("=" + q);
        p = a - b;
        edthieu.setText("=" + p);
    }
}