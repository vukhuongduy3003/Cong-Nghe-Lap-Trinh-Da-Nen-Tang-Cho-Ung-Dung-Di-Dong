package com.example.dangnhap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    Context context;
    int resource;
    List<User> users;

    public UserAdapter(@NonNull Context context, int resource, @NonNull List<User>
            objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.users = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull
    ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView =
                    LayoutInflater.from(context).inflate(R.layout.list_user, parent, false);
            viewHolder.tvname = convertView.findViewById(R.id.tvname);
            viewHolder.tvmail = convertView.findViewById(R.id.tvmail);
            viewHolder.tvcontact = convertView.findViewById(R.id.tvcontact);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        User user = users.get(position);
        viewHolder.tvname.setText(user.getName());
        viewHolder.tvmail.setText(user.getMail());
        viewHolder.tvcontact.setText(user.getContact());
        return convertView;
    }

    public class ViewHolder {
        TextView tvname;
        TextView tvmail;
        TextView tvcontact;
    }
}

