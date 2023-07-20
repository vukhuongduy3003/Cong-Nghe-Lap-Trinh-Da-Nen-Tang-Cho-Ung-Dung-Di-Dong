package vn.com.lab_5.bai_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import vn.com.lab_5.R;

public class MainActivity extends AppCompatActivity {
ImageView imcoccoc,imcall,imsms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai_3);
        imcall = findViewById(R.id.imcall);
        imcoccoc = findViewById(R.id.imcoccoc);
        imsms = findViewById(R.id.imsms);
        imcoccoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coccoc.com"));
                startActivity(intent);
            }
        });
        imcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
            }
        });
    }

}