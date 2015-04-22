package com.compass.ingenium.myapplication;

import java.util.ArrayList;

public class Grove{
    
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
    
    public void addTree( Tree tree)
    {
        trees.add( tree);
    }
    
    public void removeTree( int location)
    {
        trees.remove( location);
    }
}