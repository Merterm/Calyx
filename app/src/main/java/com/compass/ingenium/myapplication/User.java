package com.compass.ingenium.myapplication;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by Mert Inan on 19.4.2015.
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
}
