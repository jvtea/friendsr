package com.example.joost.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    public Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // get info from Friend item
        TextView name = findViewById(R.id.Name);
        TextView bio = findViewById(R.id.Bio);
        ImageView image = findViewById(R.id.Picture);

        // set texts and image
        name.setText(retrievedFriend.getName());
        bio.setText(retrievedFriend.getBio());
        image.setImageResource(retrievedFriend.getDrawableId());

        // get rating bar view
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float storedRating = prefs.getFloat("rating" + retrievedFriend.getName(), 0);

        if (storedRating != 0) {
            ratingBar.setRating(storedRating);
        }

        ratingBar.setOnRatingBarChangeListener(new BarChangeListener());
    }

    private class BarChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();

            editor.putFloat("rating" + retrievedFriend.getName(), rating);

            editor.apply();

            Log.d("RatingBarChange", "ja hoor");
        }
    }
}
