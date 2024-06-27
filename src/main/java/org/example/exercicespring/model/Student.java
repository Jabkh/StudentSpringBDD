package org.example.exercicespring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

@Validated
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Min(value = 1, message = "Age must be greater than 0")
    @Max(value = 100, message = "Age must be less than 101")
    private int age;

    @NotBlank(message = "Email is mandatory")
    private String email;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank(message = "First name is mandatory") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "First name is mandatory") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "Last name is mandatory") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Last name is mandatory") String lastName) {
        this.lastName = lastName;
    }

    @Min(value = 1, message = "Age must be greater than 0")
    @Max(value = 100, message = "Age must be less than 101")
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 1, message = "Age must be greater than 0") @Max(value = 100, message = "Age must be less than 101") int age) {
        this.age = age;
    }

    public @NotBlank(message = "Email is mandatory") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is mandatory") String email) {
        this.email = email;
    }
}