package com.compass.ingenium.myapplication;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.compass.ingenium.myapplication.modelclasses.Post;


public class PostController extends ActionBarActivity {

    //properties
    Post post;
    EditText descriptionView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        descriptionView = (EditText) findViewById(R.id.post_main_description);
        imageView = (ImageView) findViewById(R.id.post_main_image);

        post = (Post) getIntent().getSerializableExtra("post");
        Toolbar toolbar = (Toolbar) findViewById(R.id.post_toolbar);
        toolbar.setTitle(post.getTitle());
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);

        descriptionView.setText(post.getDescription());
        imageView.setImageBitmap(NewPostDialogFragment.tempBitmap);
    }
}
