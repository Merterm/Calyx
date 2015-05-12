package com.compass.ingenium.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.compass.ingenium.myapplication.modelclasses.*;
import com.compass.ingenium.myapplication.modelclasses.Post;

import java.util.ArrayList;


public class LeafController extends ActionBarActivity implements NewPostDialogFragment.PostDialogListener{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Leaf leaf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaf_controller);

        //Getting the leaf from the previous activity
        leaf = (Leaf) getIntent().getSerializableExtra("leaf");

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(leaf.getName());
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);


        //Recycler
        recyclerView = (RecyclerView) findViewById(R.id.post_recycler_view);
        //recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PostRecycler(LeafController.this, leaf.getPosts());
        recyclerView.setAdapter(adapter);

        //Leaf properties
        TextView creatorText = (TextView) findViewById(R.id.leaf_main_creator);
        TextView descriptionText = (TextView) findViewById(R.id.leaf_main_description);
        TextView memberText = (TextView) findViewById(R.id.leaf_main_member);
        creatorText.setText(leaf.getCreator().getUsername());
        descriptionText.setText(leaf.getDescription());
        memberText.setText(leaf.getMembers().size() + " Members");

        //Floating action button interaction
        findViewById(R.id.add_post_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of the dialog fragment and show it
                DialogFragment dialog = new NewPostDialogFragment();
                dialog.show(getSupportFragmentManager(), "NewPostDialogFragment");
                Toast.makeText(LeafController.this, "Clicked Floating Action Button", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_leaf_controller, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        if ( !NewPostDialogFragment.newPostTitle.equals("") && !NewPostDialogFragment.newPostDescription.equals("")) {
            Toast.makeText(getApplicationContext(), "Your post is attached to the Leaf", Toast.LENGTH_LONG)
                    .show();

            //Instantiating the post
            Post createdPost = new Post(NewPostDialogFragment.newPostTitle,
                    NewPostDialogFragment.newPostDescription, GroveController.user, null);

            //Adding the post to the leaf
            leaf.addPost(createdPost);
            NewPostDialogFragment.newPostTitle = null;
            NewPostDialogFragment.newPostDescription= null;
        }
        else {
            Toast.makeText(getApplicationContext(),
                    "Please enter the title and description!", Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }

    /**PostRecycler for the Leaf Page**/
    public class PostRecycler extends RecyclerView.Adapter<PostRecycler.ViewHolder> {

        //Properties
        private ArrayList<Post> posts;
        private Context context;

        //Constructor
        public PostRecycler(Context context, ArrayList<Post> posts){
            this.posts = posts;
            this.context = context;
        }

        @Override
        public PostRecycler.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            // create a new view
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.post_card, viewGroup, false);

            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(final PostRecycler.ViewHolder viewHolder, final int i) {
            //Setting text for title, creator, description, leaf no of the Tree in the grove list
            viewHolder.titleView.setText( posts.get(i).getTitle());
            viewHolder.creatorView.setText( posts.get(i).getCreator().getUsername());
            viewHolder.descriptionView.setText(posts.get(i).getDescription());

            //Setting the image of the post
            viewHolder.imageView.setBackground(context.getResources().getDrawable(R.mipmap.ic_launcher));

            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //intent
                    Intent intent = new Intent(context, PostController.class);
                    intent.putExtra("post", posts.get(i));
                    intent.putExtra("post_position", i);
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return posts.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            //Properties
            protected TextView titleView, creatorView, descriptionView;
            protected ImageView imageView;
            protected CardView cardView;
            protected Button button;

            //Constructor
            public ViewHolder(View itemView) {
                super(itemView);
                titleView =  (TextView) itemView.findViewById(R.id.post_title);
                creatorView = (TextView) itemView.findViewById(R.id.post_creator);
                descriptionView = (TextView) itemView.findViewById(R.id.post_description);
                imageView = (ImageView) itemView.findViewById(R.id.post_image);
                cardView = (CardView) itemView.findViewById(R.id.post_card);
                button = (Button) itemView.findViewById(R.id.post_button);
            }
        }
    }
}

