package com.example.vidu1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonActivity extends AppCompatActivity {
ListView lvJSON;
Button btnTroVe;
JSONObject j1,j2;
List<String> ds=new ArrayList<>();
ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        this.setTitle("JSON");
        lvJSON=findViewById(R.id.lvJSON_Hienthi);
        btnTroVe=findViewById(R.id.btnTroVe_JSON);
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        String nguoi1="{'hoten':'Pham Xuan Hoang','sdt':'098676565'}";
        String nguoi2="{'hoten':'Pham Thi Ha','sdt':'0986745460'}";
        try {
            j1= new JSONObject(nguoi1);
            j2= new JSONObject(nguoi2);
            ds.add(j1.getString("hoten")+"-"+j1.getString("sdt"));
            ds.add(j2.getString("hoten")+"-"+j2.getString("sdt"));
            adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,ds);
            lvJSON.setAdapter(adapter);
        }catch (Exception e)
        {

        }

    }
}