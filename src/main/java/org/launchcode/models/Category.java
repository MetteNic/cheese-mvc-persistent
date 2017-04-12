package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mettenichols on 4/9/17.
 */

@Entity
public class Category {


    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min =3, max = 15)
    private String name;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Cheese> cheeses = new ArrayList<>();

    //Constructors
    public Category(){};

    public Category(String name){

        this.name = name;


    }

    //getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }




}
