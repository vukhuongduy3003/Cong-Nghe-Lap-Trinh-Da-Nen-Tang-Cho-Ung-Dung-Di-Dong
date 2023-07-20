package vn.com.lab_5.vi_du_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vn.com.lab_5.R;

public class MainActivity extends AppCompatActivity {

    Button btnphu;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnphu = (Button) findViewById(R.id.btnEdit);
        tv1 = (TextView) findViewById(R.id.txt1);

        btnphu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                String s = tv1.getText().toString();
                intent.putExtra("dulieu", s);
                startActivityForResult(intent, MainActivity2.CONTEXT_INCLUDE_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MainActivity2.TRAVE_ATV1){
            String s = data.getStringExtra("dulieu1");
            tv1.setText(s);
        }
    }
}