package com.example.joost.friendsr;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friends = new ArrayList<>();

    public FriendsAdapter(Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // get correct friend from array
        Friend friend = friends.get(position);

        // load imageview and textview
        TextView text = convertView.findViewById(R.id.Name);
        ImageView image = convertView.findViewById(R.id.Picture);

//        // get name and image ID
//        String friendName = friend.getName();
//        int drawableID = friend.getDrawableId();

        // set text and image
        text.setText(friend.getName());
        image.setImageResource(friend.getDrawableId());

        return convertView;
    }
}

