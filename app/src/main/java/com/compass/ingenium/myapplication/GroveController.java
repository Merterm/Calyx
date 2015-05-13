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
import com.compass.ingenium.myapplication.modelclasses.Post;
import com.compass.ingenium.myapplication.modelclasses.Tree;
import com.compass.ingenium.myapplication.modelclasses.User;


public class GroveController extends ActionBarActivity implements NewTreeDialogFragment.TreeDialogListener{

    // Temporary properties
    static User user = new User("Merterm", "mertincek@hotmail.com", "12345");
    Grove grove = new Grove();
    Leaf mathLeaf1 = new Leaf(user);
    Leaf mathLeaf2 = new Leaf(user);
    Leaf mathLeaf3 = new Leaf(user);
    Leaf mathLeaf4 = new Leaf(user);
    Leaf csLeaf = new Leaf(user);
    Leaf scienceLeaf = new Leaf(user);
    Leaf quantumLeaf = new Leaf(user);
    Leaf masterLeaf = new Leaf(user);
    Leaf bioLeaf = new Leaf(user);
    Tree tree = new Tree( user, "Mathematics Topics", "Let's learn Maths together!");
    Tree tree2 = new Tree( user, "CS102 Projects", "You can reach all the projects, here!");
    Tree tree3 = new Tree( user, "Science Fair", "Upload your science projects to this tree!");
    Tree tree4 = new Tree( user, "Quantum Computing", "Putting quanta to your computer");
    Tree tree5 = new Tree( user, "Bioinformatics Co");
    Tree tree6 = new Tree( user, "Mr. Forringthon's Master Students", "I will check your projects from here!");

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

        //Leaf properties
        mathLeaf1.setDescription("You can see every research about Integrals here");
        mathLeaf1.setName("Integral");
        mathLeaf1.addMember(user);
        mathLeaf1.addMember(user);
        mathLeaf1.addPost(new Post("Title", "description", user, null));

        //Leaf properties
        mathLeaf2.setDescription("You can see every research about Integrals here");
        mathLeaf2.setName("Integral");
        mathLeaf2.addMember(user);
        mathLeaf2.addMember(user);
        mathLeaf2.setLeafImageId(R.drawable.group_image1);
        mathLeaf2.addPost(new Post("Title", "description", user, null));

        //Leaf properties
        mathLeaf3.setDescription("You can see every research about Integrals here");
        mathLeaf3.setName("Integral");
        mathLeaf3.addMember(user);
        mathLeaf3.addMember(user);
        mathLeaf3.setLeafImageId(R.drawable.group_image2);
        mathLeaf3.addPost(new Post("Title", "description", user, null));

        //Leaf properties
        mathLeaf4.setDescription("You can see every research about Integrals here");
        mathLeaf4.setName("Integral");
        mathLeaf4.addMember(user);
        mathLeaf4.addMember(user);
        mathLeaf4.setLeafImageId(R.drawable.group_image3);
        mathLeaf4.addPost(new Post("Title", "description", user, null));

        //Tree properties
        tree.addLeaf(mathLeaf1);
        tree.addLeaf(mathLeaf2);
        tree.addLeaf(mathLeaf3);
        tree.addLeaf(mathLeaf4);
        tree2.addLeaf(csLeaf);
        tree3.addLeaf(scienceLeaf);
        tree4.addLeaf(quantumLeaf);
        tree5.addLeaf(bioLeaf);
        tree6.addLeaf(masterLeaf);
        tree.setTreeImageID(R.drawable.tree1);
        tree2.setTreeImageID(R.drawable.tree2);
        tree3.setTreeImageID(R.drawable.tree1);
        tree4.setTreeImageID(R.drawable.tree2);
        tree5.setTreeImageID(R.drawable.tree1);
        tree6.setTreeImageID(R.drawable.tree2);

        //Grove Properties
        grove.addTree(tree);
        grove.addTree( tree2);
        grove.addTree( tree3);
        grove.addTree( tree4);
        grove.addTree( tree5);
        grove.addTree( tree6);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Grove");
        toolbar.setTitleTextColor( getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);

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
