package vn.com.doantrunghuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btnTraLoi = findViewById(R.id.btnTraLoi);
        Button btnBack = findViewById(R.id.btnBack);
        btnTraLoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioButton1 = findViewById(R.id.radioButton);
                boolean isCorrectAnswerSelected = false;
                if (radioButton1.isChecked()) {
                    isCorrectAnswerSelected = true;
                } else {
                    isCorrectAnswerSelected = false;
                }

                if (isCorrectAnswerSelected) {
                    Toast.makeText(getApplicationContext(), "Bạn đã trả lời đúng", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Bạn đã trả lời sai", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}