package me.maiz.ds.multimodule.emallassemble.web.thymeleaf.model;

public class User {

    private String name;

    private String blogAddress;

    public User(String name, String blogAddress) {
        this.name = name;
        this.blogAddress = blogAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlogAddress() {
        return blogAddress;
    }

    public void setBlogAddress(String blogAddress) {
        this.blogAddress = blogAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", blogAddress='" + blogAddress + '\'' +
                '}';
    }
}
