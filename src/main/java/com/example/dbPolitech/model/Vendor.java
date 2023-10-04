package com.example.dbPolitech.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "vendor")
public class Vendor implements GetParam{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;
    @Column(name = "typeTransport")
    private String typeTransport;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor")
    private List<Product> vendor = new ArrayList<>();


    @Override
    public Object getOne() {
        return name;
    }

    @Override
    public Object getTwo() {
        return country;
    }

    @Override
    public Object getThree() {
        return typeTransport;
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
