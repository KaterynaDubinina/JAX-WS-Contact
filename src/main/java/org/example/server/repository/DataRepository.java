package org.example.server.repository;

import org.example.server.entity.Contact;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {

    public List<Contact> fetchData() {
        List<Contact> list = new ArrayList<>();
        list.add(new Contact("Марія", "maria@mail.com"));
        list.add(new Contact( "Іван", "ivan@mail.com"));
        list.add(new Contact( "Ганна", "hanna@mail.com"));
        list.add(new Contact( "Рафаель", "rafael@mail.com"));
        list.add(new Contact( "Микита", "mikita@mail.com"));
        list.add(new Contact( "Катерина", "kateryna@mail.com"));
        list.add(new Contact( "Злата", "zlata@mail.com"));
        list.add(new Contact( "Павло", "pavlo@mail.com"));
        return list;
    }
}
