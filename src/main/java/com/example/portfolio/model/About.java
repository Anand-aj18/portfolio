package com.example.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name="about")
public class About {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    @Column(length=2000)
    private String bio;
    private String avatarUrl;

    public About(){}
    public About(String name,String title,String bio,String avatarUrl){
        this.name=name;this.title=title;this.bio=bio;this.avatarUrl=avatarUrl;
    }
    // getters/setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    public String getBio(){return bio;}
    public void setBio(String bio){this.bio=bio;}
    public String getAvatarUrl(){return avatarUrl;}
    public void setAvatarUrl(String avatarUrl){this.avatarUrl=avatarUrl;}
}
