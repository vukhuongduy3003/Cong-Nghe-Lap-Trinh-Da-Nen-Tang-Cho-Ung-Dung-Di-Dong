package com.example.vidu2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Quan ly cong viec");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.mnuGoiDien:
                Intent intent1=new Intent(MainActivity.this,GoiDienActivity.class);
                startActivity(intent1);
                break;
            case R.id.mnuNhanTin:
                Intent intent2=new Intent(MainActivity.this,NhantinActivity.class);
                startActivity(intent2);
                break;
            case R.id.mnuGiaiTri:
                Intent intent3=new Intent(MainActivity.this,GiaiTriActivity.class);
                startActivity(intent3);
                break;
            case R.id.mnuDuyetWeb:
                Intent intent4=new Intent(MainActivity.this,DuyetWebActivity.class);
                startActivity(intent4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}