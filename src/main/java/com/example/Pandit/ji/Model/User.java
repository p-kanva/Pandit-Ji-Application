package com.example.Pandit.ji.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Column(unique = true)
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Mobile number is required")
    @Column(name = "mobile_number", unique = true)
    private String mobileNumber;

    @Min(value = 1, message = "Age should be at least 1")
    private Integer age;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @NotNull(message = "Please enter the password")
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "User type is required")
    private UserType userType;

    // Optional field, relevant only if userType == PANDIT
    private Integer yearsOfExperience;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Integer getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }
}
