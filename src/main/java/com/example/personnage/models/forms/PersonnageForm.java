package com.example.personnage.models.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonnageForm {

    @NotNull
    @Size(min = 2, max = 30)
    private String firstname;

    @NotNull
    @Size(min = 2, max = 30)
    private String lastname;

    public String getFirstname() {

        return firstname;
    }

    public void setFirstname(String firstname) {

        this.firstname = firstname;
    }

    public String getLastname() {

        return lastname;
    }

    public void setLastname(String lastname) {
        
        this.lastname = lastname;
    }
}