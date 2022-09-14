package com.eazybytes.eazyschool.models;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Contact {

    @NotBlank(message = "Name cannot be blank!")
    @Size(min = 3, message="Name should be at least 3 characters long!")
    public String name;

    @NotBlank(message = "Mobile number cannot be blank!")
    @Pattern(regexp = "^$|[0-9]{8}", message = "Please provide a valid 8-digit mobile number!")
    public String mobileNum;

    @NotBlank(message = "Email cannot be blank!")
    @Email(message = "Please provide a valid email address!")
    public String email;

    @NotBlank(message = "Subject cannot be blank!")
    @Size(min = 5, message = "Subject should be at least 5 characters long!")
    public String subject;

    @NotBlank(message =  "Message cannot be blank!")
    @Size(min = 10, message = "Message should be at least 10 characters long!")
    public String message;

}
