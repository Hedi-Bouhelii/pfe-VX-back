package pfe.Assuré;

import jakarta.persistence.*;
import lombok.*;
import pfe.role.Role;
import pfe.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Assure extends User {
    private String firstName;
    private String lastName;
    private int tel;
    private int cin;
    private String address;
    private String agence;

    public Assure(String email, String password, Role role, String firstName, String lastName, int tel, int cin, String address, String agence) {
        super(email, password, role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.cin = cin;
        this.address = address;
        this.agence = agence;
    }
}
