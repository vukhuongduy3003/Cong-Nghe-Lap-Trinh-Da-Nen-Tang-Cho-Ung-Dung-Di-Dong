package vn.com.lab_5.bai_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.com.lab_5.R;

public class ActivityA extends AppCompatActivity {
    EditText edta, edtb, edtc;
    Button btchuyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        edta = (EditText) findViewById(R.id.edta);
        edtb = (EditText) findViewById(R.id.edtb);
        edtc = (EditText) findViewById(R.id.edtc);
        btchuyen = (Button) findViewById(R.id.btchuyen);
        btchuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atvb();
            }
        });
    }

    private void atvb() {
        if (!edta.getText().toString().equals(" ") || !edtb.getText().toString().equals(" ") || !edtc.getText().toString().equals(" ")) {
            try {
                double a = Double.parseDouble(edta.getText().toString());
                double b = Double.parseDouble(edtb.getText().toString());
                double c = Double.parseDouble(edtc.getText().toString());
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                intent.putExtra("numa", a);
                intent.putExtra("numb", b);
                intent.putExtra("numc", c);
                startActivityForResult(intent, 2);
            } catch (Exception e) {
                Toast.makeText(this, "Sai định dạng hệ số a, b, c", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Nhập đầy đủ hệ số a, b, c", Toast.LENGTH_SHORT).show();
        }
    }
}