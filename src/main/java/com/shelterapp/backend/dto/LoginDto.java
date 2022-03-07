package com.shelterapp.backend.dto;

import lombok.Data;


public class LoginDto {

    //JSON packet key string must match exactly with column name, case and syntax
    //if not posting booleans, GET request to see the formatting of the column names
    //copy and paste from the ResponseBody, the exact column name
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
