package vn.com.nguyen_thi_thanh_xuan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final String arr[]={"Nguyễn Đại Nhân","Trần Đại Nghĩa","Hoàng Đại Lễ","Phạm Đại Trí", "Trương Đại Tín", "Hồ Đại Đức"};
        ListView lv=(ListView) findViewById(R.id.lvemployee);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);
        lv.setAdapter(adapter);
    }
}