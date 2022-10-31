package com.example.servletdemo;

public class userData {
    String firstName;
    String lastName;
    long age;
    String phone;

    public void setUserData(String firstName, String sirName, long age,
                            String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public long getAge() {
        return this.age;
    }
    public String getPhone() {
        return this.phone;
    }
}
