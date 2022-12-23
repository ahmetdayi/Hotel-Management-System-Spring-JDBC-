package org.cs202.entity.dto;

public class CreateUserRequest {

    private String name;

    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public CreateUserRequest(String name, String role) {
        this.name = name;
        this.role = role;
    }


    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
