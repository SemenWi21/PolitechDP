package com.example.dbPolitech.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NameColumn {

    private ArrayList<String> arrayList;

    public List<String> getColumnNameProduct(){
        arrayList = new ArrayList<>();
        arrayList.add("Продукт");
        arrayList.add("Категория");
        arrayList.add("Тип");

        return arrayList;
    }

    public List<String> getColumnNameCategory(){
        arrayList = new ArrayList<>();
        arrayList.add("Название");
        arrayList.add("Свежесть");
        arrayList.add("Оценка");

        return arrayList;
    }

    public List<String> getColumnNameVendor(){
        arrayList = new ArrayList<>();
        arrayList.add("Название");
        arrayList.add("Страна");
        arrayList.add("Тип транспорта");

        return arrayList;
    }
}
