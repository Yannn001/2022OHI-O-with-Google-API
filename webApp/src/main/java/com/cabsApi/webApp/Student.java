package com.cabsApi.webApp;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    @Indexed(unique = true)
    private String lastName;
    private String gender;

    public Student(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
}
