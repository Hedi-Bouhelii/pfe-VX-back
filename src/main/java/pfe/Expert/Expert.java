package pfe.Expert;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pfe.role.Role;
import pfe.user.User;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Setter
public class Expert extends User {
    private String name;
    private int tel;
    private String address;

    public Expert(String email, String password, Role role, String name, int tel, String address) {
        super(email, password,role);
        this.name = name;
        this.tel = tel;
        this.address = address;
    }

    public Expert(Integer id,String email, String name, int tel, String address) {
        super(id, email);
        this.name = name;
        this.tel = tel;
        this.address = address;
    }


}
