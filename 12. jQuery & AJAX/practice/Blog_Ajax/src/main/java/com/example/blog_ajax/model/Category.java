package com.example.blog_ajax.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
@Id
@Column(name = "category_id")
private int id;
private String name;
@JsonBackReference
@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
Set<Blog> blogSet;

    public Category() {
    }

    public Category(int id, String name, Set<Blog> blogSet) {
        this.id = id;
        this.name = name;
        this.blogSet = blogSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Blog> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<Blog> blogSet) {
        this.blogSet = blogSet;
    }
}
