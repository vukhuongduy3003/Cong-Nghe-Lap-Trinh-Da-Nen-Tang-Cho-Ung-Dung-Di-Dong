package com.example.dangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListMonAn extends AppCompatActivity {

    ListView listView;
    ArrayList<String> listData;
    ArrayAdapter<String> adapter;
    Context context;

    Button buttonEdit, btnNext;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mon_an);

        context = this;
        listView = findViewById(R.id.lv);
        buttonEdit = findViewById(R.id.btnAdd);
        editText = findViewById(R.id.edtText);
        btnNext = findViewById(R.id.btnNext);

        listData = new ArrayList<>();
        listData.add("Cơm");
        listData.add("Phở bò");
        listData.add("Phở gà");
        listData.add("Bánh cuốn");
        listData.add("Bún cá");
        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);


        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editText.getText().toString().trim();
                listData.add(item);
                adapter.notifyDataSetChanged();
                Toast.makeText(ListMonAn.this, "done", Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, listData.get(i), Toast.LENGTH_LONG).show();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListMonAn.this, Json.class);
                startActivity(intent);
            }
        });
    }
}