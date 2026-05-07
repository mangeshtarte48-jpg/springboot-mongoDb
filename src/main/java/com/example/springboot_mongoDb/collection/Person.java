package com.example.springboot_mongoDb.collection;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Person {

    private String personId;
    private String personName;
    private String address;
    private Integer age;
}
