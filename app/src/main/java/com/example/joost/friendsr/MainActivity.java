package com.example.joost.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final private int NUMFRIENDS = 10;

    ArrayList<Friend> friends = new ArrayList<>();

    String[] names =    {"Arya", "Cersei", "Daenerys", "Jaime", "Jon", "Jorah",
                         "Margaery", "Melisandre", "Sansa", "Tyrion"};

    String[] bios =    {"I am Arya!!!!!!!", "Cersei, HAHA.", "Daenerys, lolz.",
                        "I am Jaime. Incest.", "JON SNOW", "My name is Jorah. I like murder and sandwiches",
                        "Margaery, that's a lot like margarine. Cool huh?! HAHAHA",
                        "Melisandre is not an actual name. Sorry about that", "I am Sansa and I complain.",
                        "I am small, but alright."};

    String[] image_ids = {"arya", "cersei", "daenerys", "jaime", "jon", "jorah",
                         "margaery", "melisandre", "sansa", "tyrion"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < NUMFRIENDS; i++) {
            Friend friend = new Friend(names[i], bios[i], getResources().getIdentifier(image_ids[i], "drawable", getPackageName()));
            friends.add(friend);
        }

        System.out.println("friends: " + friends);

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);

        GridView gridView = (GridView) findViewById(R.id.GridView);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new GridItemClickListener());

    }


    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);

            String name = clickedFriend.getName();

            Log.d("klik", name);

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);


        }
    }

}
