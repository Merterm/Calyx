package com.compass.ingenium.myapplication.modelclasses;

import java.io.Serializable;
import java.util.ArrayList;

public class Grove implements Serializable{
    
    //properties
    protected ArrayList<Tree> trees;
    
    //constructors
    public Grove()
    {
        trees = new ArrayList<Tree>();
    }
    
    public Grove( ArrayList<Tree> trees)
    {
        this.trees = trees;
    }
    
    //methods
    
    public Tree getTree( int i)
    {
        return trees.get(i);
    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }
    
    public void addTree(Tree tree)
    {
        trees.add( tree);
    }
    
    public void removeTree( int location)
    {
        trees.remove( location);
    }
}