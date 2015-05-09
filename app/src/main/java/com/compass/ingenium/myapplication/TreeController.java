package com.compass.ingenium.myapplication;

import java.util.ArrayList;
import java.util.Locale;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.compass.ingenium.myapplication.modelclasses.Leaf;
import com.compass.ingenium.myapplication.modelclasses.Tree;


public class TreeController extends ActionBarActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    Tree tree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //Getting the extras from the intent
        tree = (Tree) getIntent().getSerializableExtra("tree");

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


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return LeafFragment.newInstance(position + 1, tree.getLeafs(), tree);
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
        private static ArrayList<Leaf> leafs;
        private static Tree tree;
        private static int sectionNumber;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static LeafFragment newInstance(int sectionNumber, ArrayList<Leaf> leafs, Tree tree) {
            LeafFragment.sectionNumber = sectionNumber;
            LeafFragment.leafs = leafs;
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

            //Setting the background of the tree to the tree image
            if(tree.getTreeImageID() == R.drawable.tree1)
                rootView.findViewById(R.id.pager).setBackground(getResources().getDrawable(R.drawable.tree1));
            else if(tree.getTreeImageID() == R.drawable.tree2)
                rootView.findViewById(R.id.pager).setBackground(getResources().getDrawable(R.drawable.tree2));

            //Getting the properties of the card
            TextView titleView =  (TextView) rootView.findViewById(R.id.leaf_title);
            TextView creatorView = (TextView) rootView.findViewById(R.id.creator_item);
            TextView descriptionView = (TextView) rootView.findViewById(R.id.description_item);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.image_item);
            CardView cardView = (CardView) rootView.findViewById(R.id.leaf_in_tree_card);

            //Changing the properties according to leaf
            titleView.setText(leafs.get(sectionNumber).getName());



            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LeafController.class);
                    intent.putExtra("leaf", leafs.get(sectionNumber));
                    startActivity(intent);
                }
            });
            return rootView;
        }
    }

}
