package com.example.bt6k15;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        final String[] s = {""};
        List<String> list = new ArrayList<>();
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(MainActivity2.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        listView.setAdapter(adapter);
        Button btnThem = findViewById(R.id.btnThem);
        EditText txtSDT = findViewById(R.id.txtSDT);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sdt = txtSDT.getText().toString();
                if (!sdt.isEmpty()) {
                    list.add(sdt);
                    adapter.notifyDataSetChanged();
                    txtSDT.setText("");
                } else {
                    Toast.makeText(MainActivity2.this, "Ô nhập không được để trống!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                s[0] = list.get(position);
            }
        });
        Button btnGoiDien = findViewById(R.id.btnGoiDien);
        btnGoiDien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s[0].isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Bạn phải chọn SĐT trước khi gọi", Toast.LENGTH_SHORT).show();
                } else {
                    Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + s[0]));
                    startActivity(call);
                    s[0] = "";
                }
            }
        });
        Button btnTiep = findViewById(R.id.btnTiep);
        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}