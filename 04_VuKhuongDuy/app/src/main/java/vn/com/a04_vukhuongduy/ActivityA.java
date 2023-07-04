package vn.com.a04_vukhuongduy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityA extends AppCompatActivity {

    private Button btnActivityB, btnActivityC;
    private EditText txtInputA, txtInputB, txtInputResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);

        txtInputA = findViewById(R.id.txtInputA);
        txtInputB = findViewById(R.id.txtInputB);
        txtInputResult = findViewById(R.id.txtInputResult);
        btnActivityB = findViewById(R.id.btnActivityB);
        btnActivityC = findViewById(R.id.btnActivityC);

        btnActivityB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String a = txtInputA.getText().toString();
                    String b = txtInputB.getText().toString();
                    if (!a.equals("") && !b.equals("")) {
                        Intent intent = new Intent(ActivityA.this, ActivityB.class);
                        Bundle bundle = new Bundle();
                        bundle.putDouble("soa", Double.parseDouble(a));
                        bundle.putDouble("sob", Double.parseDouble(b));
                        intent.putExtra("bundle", bundle);
                        startActivityForResult(intent, 1);
                    } else {
                        Toast.makeText(ActivityA.this, "Không được để trống", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e) {
                    Toast.makeText(ActivityA.this, "Bạn phải nhập số thực vào chỗ trống", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnActivityC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String a = txtInputA.getText().toString();
                    String b = txtInputB.getText().toString();
                    if (!a.equals("") && !b.equals("")) {
                        Intent intent = new Intent(ActivityA.this, ActivityC.class);
                        Bundle bundle = new Bundle();
                        bundle.putDouble("soa", Double.parseDouble(a));
                        bundle.putDouble("sob", Double.parseDouble(b));
                        intent.putExtra("bundle", bundle);
                        startActivityForResult(intent, 5);
                    } else {
                        Toast.makeText(ActivityA.this, "Không được để trống", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e) {
                    Toast.makeText(ActivityA.this, "Bạn phải nhập số thực vào chỗ trống", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5 && resultCode == 5) {
            String result = data.getStringExtra("result");
            txtInputResult.setText(result);
        } else if (requestCode == 1 && resultCode == RESULT_OK) {
            String result = data.getStringExtra("result");
            txtInputResult.setText(result);
        }
    }
}