package com.compass.ingenium.myapplication.modelclasses;

import java.util.ArrayList;
/**
 * name: Tree
 * description: Tree class which will hold leaf classes
 * author: imge.gokalp
 * version 1.0
 * date: 22/04/2015
 */ 
public class Tree
{
        // constants
        protected final User CREATOR;
    
        // properties
        protected String description;
        protected ArrayList<Leaf> leafs;
        protected ArrayList<User> members;
        
        // constructors
        public Tree (User creator)
        {
          CREATOR = creator;
          leafs = new ArrayList<>();
          members = new ArrayList<>();
        }

    public Tree (User creator, String description)
    {
        CREATOR = creator;
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
        
        //set methods
        public void setDescription (String description)
        {
          this.description = description;
        }
        
        //add Methods
        public void addMember (User member)
        {
          members.add(member);
        }
        
        public void addLeaf (Leaf leaf)
        {
          leafs.add(leaf);
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