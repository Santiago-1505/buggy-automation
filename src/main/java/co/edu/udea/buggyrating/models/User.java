package co.edu.udea.buggyrating.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public static User withCredentials(
            String firstName,
            String lastName,
            String username,
            String password
    ) {

        return new User(
                firstName,
                lastName,
                username,
                password
        );
    }
}
