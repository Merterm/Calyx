package com.compass.ingenium.myapplication;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.compass.ingenium.myapplication.modelclasses.Grove;
import com.compass.ingenium.myapplication.modelclasses.Leaf;
import com.compass.ingenium.myapplication.modelclasses.Tree;
import com.compass.ingenium.myapplication.modelclasses.User;


public class GroveController extends ActionBarActivity implements NewTreeDialogFragment.TreeDialogListener{



    // Temporary properties
    static User user = new User("Merterm", "mertincek@hotmail.com", "12345");
    Grove grove = new Grove();
    Leaf emptyLeaf = new Leaf(user);
    Tree tree = new Tree( user, "Temporary Tree", "This tree has been created temporarily.");
    Tree tree2 = new Tree( user, "Mert's Tree");

    //Properties
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    static EditText inputTreeTitle;
    static EditText inputTreeDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grove);

        //Tree properties
        tree.addLeaf( emptyLeaf);
        tree2.addLeaf(emptyLeaf);
        tree.setTreeImageID(R.drawable.tree1);
        tree2.setTreeImageID(R.drawable.tree2);

        //Grove Properties
        grove.addTree( tree);
        grove.addTree( tree2);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle( "Grove");
        toolbar.setTitleTextColor( getResources().getColor(R.color.white));
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        //Recycler
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new GroveRecycler(GroveController.this, grove.getTrees());
        recyclerView.setAdapter(adapter);

        //Instantiating editText items in dialog
        inputTreeTitle = (EditText) findViewById(R.id.new_tree_title);
        inputTreeDescription = (EditText) findViewById(R.id.new_tree_description);

        //Floating Action Button
        findViewById(R.id.add_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of the dialog fragment and show it
                DialogFragment dialog = new NewTreeDialogFragment();
                dialog.show(getSupportFragmentManager(), "NewTreeDialogFragment");

                //Toast.makeText(GroveController.this, "Clicked Floating Action Button", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        if ( !NewTreeDialogFragment.newTreeTitle.equals("") && !NewTreeDialogFragment.newTreeDescription.equals("")) {
            Toast.makeText(getApplicationContext(),NewTreeDialogFragment.newTreeTitle + " is added to Grove", Toast.LENGTH_LONG)
                    .show();
            Tree createdTree = new Tree(user, NewTreeDialogFragment.newTreeTitle, NewTreeDialogFragment.newTreeDescription);
            //Adding random image to the tree
            int randomImage = (int) (Math.random() * 2 + 1);
            if (randomImage == 1)
                createdTree.setTreeImageID( R.drawable.tree1);
            else if (randomImage == 2)
                createdTree.setTreeImageID(R.drawable.tree2);

            //Adding the tree to the grove
            grove.addTree(createdTree);
            NewTreeDialogFragment.newTreeTitle = null;
            NewTreeDialogFragment.newTreeDescription= null;
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


}
