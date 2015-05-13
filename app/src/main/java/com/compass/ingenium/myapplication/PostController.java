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


public class PostController extends ActionBarActivity implements NewPostDialogFragment.PostDialogListener{

    //properties
    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        post = (Post) getIntent().getSerializableExtra("post");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(post.getTitle());
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);

    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {


    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}
