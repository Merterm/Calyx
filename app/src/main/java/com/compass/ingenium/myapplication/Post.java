package com.compass.ingenium.myapplication;

/**
 * Description: The Post Class. It contains the information when a user creates or shows a post.
 * Leaf extends this class.
 * Date: 22/04/2015
 * Version: 1.0
 * By Ertugrul Akay (Kaxell)
 *
 */
public class Post {

    //Properties
    String title;
    String description;
    User creator;
    Object content; //Will be casted to the desired object.


    public Post(){
        title="Sample";
        description="Castigat ridendo mores.Corvus oculum corvi non eruit.";
        creator= new User("Sample User","1234", "sample@sample.com");
        content=null;
    }
    public Post(String title, String description, User creator, Object Content) {
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.content = content;
    }


    //Get Methods
    public String getTitle(){return title;}
    public String getDescription(){return description;}
    public User getCreator(){return creator;}
    public Object getContent(){return content;}

    //Set Methods
    public void setContent(Object content) {
        this.content = content;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
