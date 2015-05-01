package com.compass.ingenium.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
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
    private Context context;

    //Constructor
    public GroveRecycler(Context context, ArrayList<Tree> groveData){
        this.groveData = groveData;
        this.context = context;
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
    public void onBindViewHolder(final GroveRecycler.ViewHolder viewHolder, int i) {
        //Setting text for title, creator, description, leaf no of the Tree in the grove list
        viewHolder.titleView.setText( groveData.get(i).getTitle());
        viewHolder.creatorView.setText( groveData.get(i).getCreator().getUsername());
        viewHolder.descriptionView.setText( groveData.get(i).getDescription());
        if (groveData.get(i).getLeafs().size() > 1 ) {
            viewHolder.leafNoView.setText(groveData.get(i).getLeafs().size() + " Leaves");
        }
        else
        {
            viewHolder.leafNoView.setText(groveData.get(i).getLeafs().size() + " Leaf");
        }
        //Setting the background image of card to the image of the tree
        viewHolder.imageView.setBackground(groveData.get(i).getTreeImage());

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.cardView.setCardElevation(30);
                viewHolder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.card_pressed));
                //intent example
                Intent intent = new Intent(context, TreeController.class);
                /*intent.putExtra("id", newsBean.getId());
                intent.putExtra("category", newsBean.getCategory());*/
                context.startActivity(intent);
                viewHolder.cardView.setCardElevation(10);
                viewHolder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.white));
            }
        });
    }

    @Override
    public int getItemCount() {
        return groveData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        //Properties
        protected TextView titleView, creatorView, descriptionView, leafNoView;
        protected ImageView imageView;
        protected CardView cardView;

        //Constructor
        public ViewHolder(View itemView) {
            super(itemView);
            titleView =  (TextView) itemView.findViewById(R.id.title_item);
            creatorView = (TextView) itemView.findViewById(R.id.creator_item);
            descriptionView = (TextView) itemView.findViewById(R.id.description_item);
            leafNoView = (TextView) itemView.findViewById(R.id.leaf_number_item);
            imageView = (ImageView) itemView.findViewById(R.id.image_item);
            cardView = (CardView) itemView.findViewById(R.id.tree_card);
        }
    }
}
