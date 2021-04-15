package khj.study.security.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class SignupForm {

    @NotNull(message = "First Name is required")
    private String firstName;
    @NotNull(message="Last Name is required")
    private String lastName;
    @Email(message = "Please provide a valid email address")
    @NotNull(message="Email is required")
    private String email;
    @NotNull(message="Password is required")
    private String password;
}
