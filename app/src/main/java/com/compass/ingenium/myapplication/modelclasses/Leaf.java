package com.compass.ingenium.myapplication.modelclasses;
//drawer
//profile, settings, grove, options, leaf, 

import java.io.Serializable;
import java.util.ArrayList;
public class Leaf implements Serializable
{
  //variables
  String name, description;
  User creator;
  ArrayList<Post> posts;
  ArrayList<User> members;
  Pigment pigment;
    int leafImageId;
  
  //constructor
  public Leaf(User creator)
  {
    name = "";
    description = "";
    this.creator = creator;
      members = new ArrayList<User>();
      posts = new ArrayList<Post>();
  }
  
  //methods
  //name methods
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  //description methods
  public String getDescription()
  {
    return description;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  //creator methods
  public User getCreator()
  {
    return creator;
  }
  
  //pigment methods
  public Pigment getPigment()
  {
    return pigment;
  }
  
  public void setPigment(Pigment pigment)
  {
    this.pigment = pigment;
  }
  
  //posts methods
  public ArrayList<Post> getPosts()
  {
    return posts;
  }
  
  public void addPost(Post post)
  {
    posts.add(post);
  }
  
  public Post removePost(Post post) {
      boolean exitLoop = true;
      Post tempPost = null;
      for (int i = 0; i < posts.size() && exitLoop == false; i++) {
          if (posts.get(i).equals(post)) {
              tempPost = posts.remove(i);
              exitLoop = false;
          }
      }
      return tempPost;
  }
  
  //members methods
  public ArrayList<User> getMembers()
  {
    return members;
  }
  
  public void addMember(User member)
  {
    members.add(member);
  }
  
  public User removeMember(User member) {
      boolean exitLoop = true;
      User tempUser = null;
      for (int i = 0; i < posts.size() && !exitLoop; i++) {
          if (members.get(i).equals(member)) {
              tempUser = members.remove(i);
              exitLoop = false;
          }
      }
      return tempUser;
  }

    //Image methods
    public int getLeafImageId() {
        return leafImageId;
    }

    public void setLeafImageId(int leafImageId) {
        this.leafImageId = leafImageId;
    }
}