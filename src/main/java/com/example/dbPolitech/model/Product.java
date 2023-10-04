package com.example.dbPolitech.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product implements GetParam{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private Long category;
    @Column(name = "type")
    private String type;
    @Column
    private Long vendor;

    @Override
    public Object getOne() {
        return name;
    }

    @Override
    public Object getTwo() {
        return category;
    }

    @Override
    public Object getThree() {
        return type;
    }

    @Override
    public Object getFour() {
        return vendor;
    }

    @Override
    public Object getid() {
        return id;
    }
}
