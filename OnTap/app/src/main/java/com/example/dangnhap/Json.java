package com.example.dangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Json extends AppCompatActivity {

    List<User> users = new ArrayList<>();
    ListView listuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        listuser = findViewById(R.id.listuser);
        listuser.setDivider(null);
        try {
            JSONObject object = new JSONObject("{" +
                    " users: [" +
                    " {" +
                    " name: Alita," +
                    " mail: alita@gmail.com," +
                    " contact: 0231567345" +
                    " }," +
                    " {" +
                    " name: Phineas," +
                    " mail: phineas@gmail.com," +
                    " contact: 0123456789" +
                    " }," +
                    " {" +
                    " name: Ferb," +
                    " mail: ferb@gmail.com," +
                    " contact: 0789456734" +
                    " }" +
                    " ]" +
                    "}");//tao doi tuong json
            JSONArray array = object.getJSONArray("users");//mang cac json object lay tu
            for (int i = 0; i < array.length(); i++) {
                JSONObject ob = array.getJSONObject(i);//lay ra jsonobject tai vi tri i
                User user = new User(ob.getString("name"), ob.getString("mail"), ob.getString("contact"));
                users.add(user);
            }
            UserAdapter adapter = new UserAdapter(this, R.layout.list_user, users);
            listuser.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}