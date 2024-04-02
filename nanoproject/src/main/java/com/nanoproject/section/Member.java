package com.nanoproject.section;

public class Member {

    private String name;
    private String username;
    private String password;
    private String phoneNumber;
    private String randomCode;

    public Member(String name, String username, String password, String phoneNumber) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Member(String name, String username, String randomCode) {
        this.name = name;
        this.username = username;
        this.randomCode = randomCode;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
