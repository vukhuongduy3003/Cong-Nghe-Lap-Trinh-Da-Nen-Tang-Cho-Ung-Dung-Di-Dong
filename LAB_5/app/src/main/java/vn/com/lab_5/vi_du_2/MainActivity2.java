package vn.com.lab_5.vi_du_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import vn.com.lab_5.R;

public class MainActivity2 extends AppCompatActivity {

    public static int TRAVE_ATV1 = 1000;
    Button bntchinh;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        String dulieu = i.getStringExtra("dulieu");
        bntchinh = (Button) findViewById(R.id.btnDone);
        edt = (EditText) findViewById(R.id.edt2);
        edt.setText(dulieu);

        bntchinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String s = edt.getText().toString();
                intent.putExtra("dulieu1", s);
                setResult(TRAVE_ATV1,intent);
                finish();
            }
        });
    }
}