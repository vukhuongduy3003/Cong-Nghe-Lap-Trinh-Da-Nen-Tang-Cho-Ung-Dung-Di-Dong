package vn.com.lab_5.vi_du_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.com.lab_5.R;

public class Activity2 extends AppCompatActivity {

    Button bntchinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        bntchinh = (Button) findViewById(R.id.btnChinh);

        bntchinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, Activity1.class);
                startActivity(intent);
            }
        });
    }
}