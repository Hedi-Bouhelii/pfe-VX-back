package pfe.agence;

import jakarta.persistence.*;
import lombok.*;
import pfe.Assuré.Assure;
import pfe.Expert.Expert;
import pfe.role.Role;

import java.util.ArrayList;
import java.util.List;
import pfe.user.User;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Setter
public class Agence extends User {
    private String name;
    private String matricule;
    private int tel;
    private String address;
    private String status;
    private String file;
    @OneToMany
    @JoinTable(
            name = "agence_users",
            joinColumns = @JoinColumn(name = "agence_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Assure> assure;
    @OneToMany
    @JoinTable(
            name = "agence_experts",
            joinColumns = @JoinColumn(name = "agence_id"),
            inverseJoinColumns = @JoinColumn(name = "expert_id"))
    private List<Expert> expert;


    public Agence(String email, String password, Role role, String name, String matricule, int tel, String address) {
        super(email, password, role);
        this.name = name;
        this.matricule = matricule;
        this.tel = tel;
        this.address = address;
    }

}
