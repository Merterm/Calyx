package com.compass.ingenium.myapplication;

import java.util.ArrayList;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.compass.ingenium.myapplication.modelclasses.Leaf;
import com.compass.ingenium.myapplication.modelclasses.Tree;


public class TreeController extends ActionBarActivity implements NewLeafDialogFragment.LeafDialogListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    LeafPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    Tree tree;
    static ArrayList<Leaf> leafs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);

        tree = (Tree) getIntent().getSerializableExtra("tree");
        leafs = tree.getLeafs();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new LeafPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(tree.getTitle());
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);

        //Floating Action Button
        findViewById(R.id.leaf_add_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of the dialog fragment and show it
                DialogFragment dialog = new NewLeafDialogFragment();
                dialog.show(getSupportFragmentManager(), "NewLeafDialogFragment");

                //Toast.makeText(GroveController.this, "Clicked Floating Action Button", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tree, menu);
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
        if ( !NewLeafDialogFragment.newLeafTitle.equals("") && !NewLeafDialogFragment.newLeafDescription.equals("")) {
            Toast.makeText(getApplicationContext(), NewLeafDialogFragment.newLeafTitle + " is added to Tree", Toast.LENGTH_LONG)
                    .show();

            //Instantiating the leaf
            Leaf createdLeaf = new Leaf(GroveController.user);
            createdLeaf.setName(NewLeafDialogFragment.newLeafTitle);
            createdLeaf.setDescription(NewLeafDialogFragment.newLeafDescription);
            createdLeaf.setLeafImageId(R.drawable.ingenium);

            //Adding the leaf to the tree
            tree.addLeaf(createdLeaf);
            NewLeafDialogFragment.newLeafTitle = null;
            NewLeafDialogFragment.newLeafDescription= null;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mSectionsPagerAdapter.notifyDataSetChanged();
                }
            });
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


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class LeafPagerAdapter extends FragmentStatePagerAdapter {

        public LeafPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return LeafFragment.newInstance(position + 1, tree);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return tree.getTreeSize();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Leaf " + (position + 1);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class LeafFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static Tree tree;
        private static int sectionNumber;
        private static TextView titleView, membersView, descriptionView;
        private static ImageView imageView;
        private static CardView cardView;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static LeafFragment newInstance(int sectionNumber, Tree tree) {
            LeafFragment.sectionNumber = sectionNumber;
            LeafFragment.tree = tree;
            LeafFragment fragment = new LeafFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public LeafFragment() {}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tree, container, false);

            return rootView;
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            //Getting the properties of the card
            titleView =  (TextView) getActivity().findViewById(R.id.leaf_title);
            membersView = (TextView) getActivity().findViewById(R.id.members);
            descriptionView = (TextView) getActivity().findViewById(R.id.leaf_description);
            imageView = (ImageView) getActivity().findViewById(R.id.leaf_image);
            cardView = (CardView) getActivity().findViewById(R.id.leaf_in_tree_card);

            //Setting the background of the tree to the tree image
            if(tree.getTreeImageID() == R.drawable.tree1)
                getActivity().findViewById(R.id.pager).setBackground(getResources().getDrawable(R.drawable.tree1));
            else if(tree.getTreeImageID() == R.drawable.tree2)
                getActivity().findViewById(R.id.pager).setBackground(getResources().getDrawable(R.drawable.tree2));

            //Changing the properties according to leaf
            Toast.makeText(getActivity().getApplicationContext(), leafs.get(sectionNumber-1).getName(), Toast.LENGTH_LONG).show();
            titleView.setText(leafs.get(sectionNumber-1).getName());
            descriptionView.setText(leafs.get(sectionNumber-1).getDescription());
            membersView.setText(leafs.get(sectionNumber-1).getMembers().size() + " Members");
            imageView.setBackground(getActivity().getResources().getDrawable(R.drawable.ingenium));

            //Adding an onclicklistener to the card
            cardView.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LeafController.class);
                    intent.putExtra("leaf", leafs.get(sectionNumber-1));
                    // create the transition animation - the images in the layouts
                    // of both activities are defined with android:transitionName="robot"
                    ActivityOptions options = ActivityOptions
                            .makeSceneTransitionAnimation(getActivity(), imageView, "leaf_image");
                    startActivity(intent /*options.toBundle()*/);
                }
            });
        }
    }

}
