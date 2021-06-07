package com.example.forumandroidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PostListAdapter extends BaseAdapter {
    private final Context context;
    private final List<Post> list;

    public PostListAdapter(Context context, List<Post> todoList) {
        this.context = context;
        this.list = todoList;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.posts_adapter_view, parent, false);

        Post item = list.get(position);

        TextView itemTitle = convertView.findViewById(R.id.postTitle);
        TextView itemDescription = convertView.findViewById(R.id.postText);

        itemTitle.setText(item.getTitle());
        itemDescription.setText(item.getText());

        return convertView;
    }
}