package com.example.vidu1;

import androidx.appcompat.app.AppCompatActivity;

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
import java.util.List;

public class DanhBaActivity extends AppCompatActivity {
EditText edtSoDT;
Button btnThem,btnSua,btnXoa,btnThoat,btnJSON;
ListView lvDanhBa;
List<String> dsDanhBa=new ArrayList<>();
ArrayAdapter<String> adapter;
int vitri=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);
        this.setTitle("Thong tin danh ba");
        edtSoDT=findViewById(R.id.edtSDT_Danhba);
        btnThem=findViewById(R.id.btnThem_Danhba);
        btnSua=findViewById(R.id.btnSua_Danhba);
        btnXoa=findViewById(R.id.btnXoa_Danhba);
        btnThoat=findViewById(R.id.btnThoat_Danhba);
        btnThoat=findViewById(R.id.btnThoat_Danhba);
        lvDanhBa=findViewById(R.id.lvDanhBa);
        btnJSON=findViewById(R.id.btnJSON);
        adapter=new ArrayAdapter<String>(DanhBaActivity.this, android.R.layout.simple_list_item_1,dsDanhBa);
        lvDanhBa.setAdapter(adapter);
        btnJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DanhBaActivity.this, JsonActivity.class);
                startActivity(intent);
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vitri==-1)
                    Toast.makeText(DanhBaActivity.this,"Chua chon so dien thoai can xoa",Toast.LENGTH_LONG).show();
                else
                {
                    edtSoDT.setText("");
                    dsDanhBa.remove(vitri);
                    vitri=-1;
                    adapter.notifyDataSetChanged();
                }
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vitri==-1)
                    Toast.makeText(DanhBaActivity.this,"Chua chon so dien thoai can sua",Toast.LENGTH_LONG).show();
                else
                {
                    boolean lap=false;
                    for(int i=0;i<dsDanhBa.size();i++)
                        if (i!=vitri && edtSoDT.getText().toString().equals(dsDanhBa.get(i)))
                        {
                            Toast.makeText(DanhBaActivity.this,"Trung lap so dien thoai",Toast.LENGTH_LONG).show();
                            lap=true;
                            break;
                        }
                    if (!lap)
                    {
                        dsDanhBa.set(vitri,edtSoDT.getText().toString());
                        vitri=-1;
                        edtSoDT.setText("");
                        adapter.notifyDataSetChanged();
                    }
                }

            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sdt=edtSoDT.getText().toString();
                if(sdt.equals(""))
                    Toast.makeText(DanhBaActivity.this,"So dien thoai can khac rong",Toast.LENGTH_LONG).show();
                else
                {
                    boolean ok=true;
                    for(String s:dsDanhBa)
                        if (s.equals(sdt))
                        {
                            Toast.makeText(DanhBaActivity.this,"So dien thoai da co",Toast.LENGTH_LONG).show();
                            ok=false;
                            break;
                        }
                    if(ok)
                    {
                        dsDanhBa.add(sdt);
                        adapter.notifyDataSetChanged();
                        edtSoDT.setText("");
                    }
                }
            }
        });
        lvDanhBa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtSoDT.setText(dsDanhBa.get(i));
                vitri=i;
            }
        });
        lvDanhBa.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(DanhBaActivity.this,GoiDienNhanTinActivity.class);
                intent.putExtra("sdt",dsDanhBa.get(i));
                startActivity(intent);
                return false;
            }
        });
    }
}