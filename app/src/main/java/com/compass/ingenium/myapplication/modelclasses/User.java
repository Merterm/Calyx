package com.compass.ingenium.myapplication.modelclasses;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by Batuhan Erarslan & Mert Inan on 19.4.2015.
 */
public class User {
    protected String username, password, eMail;
    protected Image profilePicture;
    protected Grove grove;
    protected ArrayList<Leaf> myLeafs;
    protected ArrayList<Post> myPosts;
    protected ArrayList<Pigment> myPigments;

    public User( String username, String password, String eMail){
        this.username = username;
        this.password = password;
        this.eMail = eMail;
        profilePicture = null;
    }

    public User(String username, String password, String eMail, Image profilePicture)
    {
        this.username = username;
        this.password = password;
        this.eMail = eMail;
        this.profilePicture = profilePicture;
    }

    //methods

    //getters
    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEMail()
    {
        return eMail;
    }

    public Image getProfilePicture()
    {
        return profilePicture;
    }

    public Grove getGrove()
    {
        return grove;
    }

    public ArrayList<Leaf> getLeafs()
    {
        return myLeafs;
    }

    public ArrayList<Post> getPosts()
    {
        return myPosts;
    }

    public ArrayList<Pigment> getPigments()
    {
        return myPigments;
    }

    //setters
    public void setPassword( String password)
    {
        this.password = password;
    }

    public void setEMail( String eMail)
    {
        this.eMail = eMail;
    }

    public void setProfilePictur( Image profilePicture)
    {
        this.profilePicture = profilePicture;
    }

    public void setGrove( Grove grove)
    {
        this.grove = grove;
    }

    //add methods
    public void addLeaf( Leaf leaf)
    {
        myLeafs.add( leaf);
    }

    public void addPost( Post post)
    {
        myPosts.add( post);
    }

    public void addLPigment( Pigment pigment)
    {
        myPigments.add( pigment);
    }

    //remove methods
    public void removeLeaf( int location)
    {
        myLeafs.remove( location);
    }

    public void removePost( int location)
    {
        myPosts.remove( location);
    }

    public void removePigment( int location)
    {
        myPigments.remove( location);
    }

}
