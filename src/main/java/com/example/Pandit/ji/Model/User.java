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
@Getter
@Setter
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private  String name;

    @Column(unique = true)
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Mobile number is required")
    @Column(name = "mobile_number", unique = true)
    private String mobileNumber;

    @Min(value = 1, message = "Age should be at least 1")
    private Integer age;





    @Enumerated(EnumType.STRING)
    @NotNull(message = "User type is required")
    private UserType userType;

    // Optional field, relevant only if userType == PANDIT
    private Integer yearsOfExperience;

}
