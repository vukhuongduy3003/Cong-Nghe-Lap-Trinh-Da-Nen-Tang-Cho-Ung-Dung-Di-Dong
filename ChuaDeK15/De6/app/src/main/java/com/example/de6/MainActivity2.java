package com.example.de6;

import android.content.Intent;
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
        List<String> list = new ArrayList<>();
        list.add("Con cò be bé - Xuân Mai");
        list.add("Mẹ yêu không nào - Bào Ngư");
        list.add("Đi học về - Mỹ Tâm");
        list.add("Chờ ngày mưa tan - Noo Phước Thịnh");
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(MainActivity2.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = list.get(i);
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("STRING", s);
                startActivity(intent);
            }
        });
    }
}