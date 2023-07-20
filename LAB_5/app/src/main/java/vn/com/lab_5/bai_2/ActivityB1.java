package vn.com.lab_5.bai_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.com.lab_5.R;

public class ActivityB1 extends AppCompatActivity {
    EditText edtaz, edtbz, edtkqz;
    Button bttinhaz, btvea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b1);
        edtaz = findViewById(R.id.edtaz);
        edtbz = findViewById(R.id.edtbz);
        edtkqz = findViewById(R.id.edtkqz);
        bttinhaz = findViewById(R.id.bttinhaz);
        btvea = findViewById(R.id.btvea);

        Intent intent = getIntent();
        final double a = intent.getDoubleExtra("numa", 0);
        final double b = intent.getDoubleExtra("numb", 0);

        edtaz.setText(String.valueOf(a));
        edtbz.setText(String.valueOf(b));
        bttinhaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinhq(a, b);
            }
        });
        btvea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
    }

    private void back() {
        if (!edtkqz.getText().toString().equals("")) {
            Intent intent = new Intent(ActivityB1.this, ActivityA.class);
            double kq1 = Double.parseDouble(edtkqz.getText().toString());
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
            edtkqz.setText("Phương trình có nghiệm " + x);
        } else {
            edtkqz.setText("Phương trình vô số nghiệm");
        }
    }
}