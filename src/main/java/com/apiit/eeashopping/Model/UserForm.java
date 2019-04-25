package com.apiit.eeashopping.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

public class UserForm {

    public String fName;
    public String lName;
    public String gender;

    public String email;

    public String password;
    public String address;
    public int contact;


    public String role;

    public String image;

}
