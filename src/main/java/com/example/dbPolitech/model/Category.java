package com.example.dbPolitech.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "category")
public class Category implements GetParam{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "fresh")
    private String fresh;
    @Column(name = "estimate")
    private String estimate;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category")
    private List<Product> products = new ArrayList<>();

    @Override
    public Object getOne() {
        return id;
    }

    @Override
    public Object getTwo() {
        return name;
    }

    @Override
    public Object getThree() {
        return fresh;
    }

    @Override
    public Object getFour() {
        return null;
    }

    @Override
    public Object getid() {
        return id;
    }
}
