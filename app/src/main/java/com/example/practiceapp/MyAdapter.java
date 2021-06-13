package com.example.practiceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    Context context;
    int[] img;
    String[] names;
    LayoutInflater layoutInflater;

    public MyAdapter(Context context, int[] img, String[] names) {
        this.context = context;
        this.img = img;
        this.names = names;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = layoutInflater.inflate(R.layout.row_listview,null);

        ImageView imageView = convertView.findViewById(R.id.iv1);
        TextView textView = convertView.findViewById(R.id.tv1);
        imageView.setImageResource(img[position]);
        textView.setText(names[position]);

        return convertView;
    }
}
