package org.academiadecodigo.javabank.command;

import org.academiadecodigo.javabank.model.Customer;

import javax.validation.constraints.*;

public class CustomerDto {

    private Integer id;
    private Integer version;

    @NotBlank(message = "first name is mandatory")
    @NotEmpty(message = "first name is mandatory")
    @Size(min = 3, max = 64)
    private String firstName;

    @NotBlank(message = "last name is mandatory")
    @NotEmpty(message = "last name is mandatory")
    @Size(min = 3, max = 64)
    private String lastName;

    @Email
    private String email;

    @Pattern(regexp = "^\\+[0-9]*$", message = "phone has invalid characters")
    @Size(min=9, max=16)
    private String phone;


    public CustomerDto(){
    }

    public CustomerDto(Customer customer){
        this.id = customer.getId();
        this.version = customer.getVersion();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();

    }

    public Integer getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

