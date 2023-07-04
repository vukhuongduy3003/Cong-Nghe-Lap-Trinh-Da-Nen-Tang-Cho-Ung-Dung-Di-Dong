package vn.com.vukhuongduy;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityA extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    private int number1, number2;
    private EditText resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        resultTextView = findViewById(R.id.txtInputResult);

        // Gửi số nguyên a và b sang ActivityB khi nhấn nút "Gửi"
        Button btnActivityB = findViewById(R.id.btnActivityB);
        btnActivityB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                intent.putExtra("number1", number1);
                intent.putExtra("number2", number2);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        // Nhập số nguyên a và b từ EditText
        EditText number1EditText = findViewById(R.id.txtInputA);
        EditText number2EditText = findViewById(R.id.txtInputB);

        number1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    number1 = Integer.parseInt(s.toString());
                }
            }
        });

        number2EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    number2 = Integer.parseInt(s.toString());
                }
            }
        });
    }

    // Nhận kết quả từ ActivityB
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            int result = data.getIntExtra("result", 0);
            resultTextView.setText(String.valueOf(result));
        }
    }
}
