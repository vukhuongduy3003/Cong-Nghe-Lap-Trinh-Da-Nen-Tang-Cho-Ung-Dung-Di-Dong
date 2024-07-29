package com.example.bt6k15;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnHienThi = findViewById(R.id.btnHienThi);
        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list = new ArrayList<>();
                ListView listView2 = findViewById(R.id.listView2);
                String json = "{\n" +
                        "  \"list\": [\n" +
                        "    {\n" +
                        "      \"ten\": \"VKD\",\n" +
                        "      \"sdt\": \"0987654321\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"ten\": \"VKD2\",\n" +
                        "      \"sdt\": \"0123456789\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                try {
                    JSONObject object = new JSONObject(json);
                    JSONArray array = object.getJSONArray("list");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);
                        String s = ob.getString("ten") + " - " + ob.getString("sdt");
                        list.add(s);
                    }
                    ArrayAdapter adapter = new ArrayAdapter(MainActivity3.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
                    listView2.setAdapter(adapter);
                } catch (Exception e) {
                    Toast.makeText(MainActivity3.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }
}