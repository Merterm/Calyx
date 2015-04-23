package com.compass.ingenium.myapplication;//drawer
//profile, settings, grove, options, leaf, 

import com.compass.ingenium.myapplication.User;

import java.util.ArrayList;
public class Leaf
{
  //variables
  String name;
  String description;
  User creator;
  ArrayList<Post> posts = new ArrayList<Post>();
  ArrayList<User> members = new ArrayList<User>();
  Pigment pigment;
  
  //constructor
  public Leaf(User creator)
  {
    name = "";
    description = "";
    this.creator = creator;
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
      for (int i = 0; i < posts.size() && exitLoop == false; i++) {
          if (members.get(i).equals(member)) {
              tempUser = members.remove(i);
              exitLoop = false;
          }
      }
      return tempUser;
  }
  

}