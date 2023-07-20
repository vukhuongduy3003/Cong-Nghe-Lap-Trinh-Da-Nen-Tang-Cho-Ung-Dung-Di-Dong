package vn.com.lab_5.bai_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.com.lab_5.R;

public class ActivityA extends AppCompatActivity {
    EditText edta, edtb;
    Button btacb, btacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_activity_a);
        edta = (EditText) findViewById(R.id.edta);
        edtb = (EditText) findViewById(R.id.edtb);
        btacb = (Button) findViewById(R.id.btacb);
        btacc = (Button) findViewById(R.id.btacc);

        btacb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atvm();
            }
        });
        btacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atvc();
            }
        });
    }

    private void atvm() {
        if (!edta.getText().toString().equals("") || !edtb.getText().toString().equals("")) {
            try {
                double a = Double.parseDouble(edta.getText().toString());
                double b = Double.parseDouble(edtb.getText().toString());
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                intent.putExtra("numa", a);
                intent.putExtra("numb", b);

                startActivityForResult(intent, 2);
            } catch (Exception e) {
                double a = Double.parseDouble(edta.getText().toString());
                double b = Double.parseDouble(edtb.getText().toString());
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                intent.putExtra("numa", a);
                intent.putExtra("numb", b);
            }
        } else {
            Toast.makeText(this, "Nhập đầy đủ a và b", Toast.LENGTH_SHORT).show();
        }
    }

    private void atvc() {
        if (!edta.getText().toString().equals("") || !edtb.getText().toString().equals("")) {
            try {
                double a = Double.parseDouble(edta.getText().toString());
                double b = Double.parseDouble(edtb.getText().toString());

                Intent intent = new Intent(ActivityA.this, ActivityC.class);
                intent.putExtra("numa", a);
                intent.putExtra("numb", b);

                startActivityForResult(intent, 2);
            } catch (Exception e) {
                Toast.makeText(this, "Sai định dạng a hoặc b", Toast.LENGTH_SHORT).show();

            }
        } else {
            Toast.makeText(this, "Nhập đầy đủ a và b", Toast.LENGTH_SHORT).show();
        }
    }
}