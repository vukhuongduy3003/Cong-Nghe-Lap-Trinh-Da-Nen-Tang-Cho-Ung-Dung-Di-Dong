package com.example.de5;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        List<String> list = new ArrayList<>();
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(MainActivity2.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        listView.setAdapter(adapter);
        Button btnThem = findViewById(R.id.btnThem);
        EditText txtTenBH = findViewById(R.id.txtTenBH);
        EditText txtCaSi = findViewById(R.id.txtCaSi);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenBH = txtTenBH.getText().toString();
                String caSi = txtCaSi.getText().toString();
                if (!tenBH.isEmpty() && !caSi.isEmpty()) {
                    list.add(tenBH + " - " + caSi);
                    adapter.notifyDataSetChanged();
                    txtTenBH.setText("");
                    txtCaSi.setText("");
                    Toast.makeText(MainActivity2.this, "Thêm bài hát thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity2.this, "Ô nhập không được để trống!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}