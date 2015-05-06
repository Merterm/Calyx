package com.compass.ingenium.myapplication.modelclasses;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * name: Tree
 * description: Tree class which will hold leaf classes
 * author: imge.gokalp
 * version 1.0
 * date: 22/04/2015
 */ 
public class Tree implements Serializable
{
    // constants
    protected final User CREATOR;

    // properties
    protected String description, title;
    protected ArrayList<Leaf> leafs;
    protected ArrayList<User> members;
    protected int treeImageID, treeSize;

    // constructors
    public Tree (User creator){
        CREATOR = creator;
        leafs = new ArrayList<>();
        members = new ArrayList<>();
    }

    public Tree (User creator, String title){
        CREATOR = creator;
        this.title = title;
        leafs = new ArrayList<>();
        members = new ArrayList<>();
    }

    public Tree (User creator, String title, String description) {
        CREATOR = creator;
        this.title = title;
        this.description = description;
        leafs = new ArrayList<>();
        members = new ArrayList<>();
    }

    // methods
        
    //get methods
    public User getCreator()
    {
      return CREATOR;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription()
    {
      return description;
    }

    public ArrayList getLeafs()
    {
      return leafs;
    }

    public ArrayList getMembers()
    {
      return members;
    }

    public int getTreeImageID() {
        return treeImageID;
    }

    public int getTreeSize() {
        return treeSize;
    }

    //set methods
    public void setDescription( String description)
    {
      this.description = description;
    }

    public void setTreeImageID( int treeImageID) {
        this.treeImageID = treeImageID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //add Methods
    public void addMember (User member)
    {
      members.add(member);
    }

    public void addLeaf (Leaf leaf)
    {
        leafs.add(leaf);
        treeSize++;
    }

    //remove methods
    public void removeLeaf (int index)
    {
      leafs.remove(index);
    }

    public void removeMember (int index)
    {
      members.remove(index);
    }

}