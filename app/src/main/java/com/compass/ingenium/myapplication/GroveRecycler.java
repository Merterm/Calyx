package com.compass.ingenium.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.compass.ingenium.myapplication.modelclasses.Tree;

import java.util.ArrayList;

/**
 * Created by Mert Inan
 * Date: 24/04/15
 */
public class GroveRecycler extends RecyclerView.Adapter<GroveRecycler.ViewHolder> {

    //Properties
    private ArrayList<Tree> groveData;

    //Constructor
    public GroveRecycler(ArrayList<Tree> groveData){
        this.groveData = groveData;
    }

    @Override
    public GroveRecycler.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.tree_card, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GroveRecycler.ViewHolder viewHolder, int i) {
        viewHolder.titleView.setText( groveData.get(i).getTitle());
        viewHolder.creatorView.setText( groveData.get(i).getCreator().getUsername());
        viewHolder.imageView.setImageDrawable( groveData.get(i).getTreeImage());

    }

    @Override
    public int getItemCount() {
        return groveData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        //Properties
        protected TextView titleView;
        protected TextView creatorView;
        protected ImageView imageView;

        //Constructor
        public ViewHolder(View itemView) {
            super(itemView);
            titleView =  (TextView) itemView.findViewById(R.id.title_item);
            creatorView = (TextView) itemView.findViewById(R.id.creator_item);
            imageView = (ImageView) itemView.findViewById(R.id.image_item);
        }
    }
}
