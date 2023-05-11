package pfe.Assuré;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfe.role.Role;

@Data
@Builder
@NoArgsConstructor
public class AssureDTO {
    private String firstName;
    private String lastName;
    private String email;
    private int tel;
    private int cin;
    private String address;
    private String agence;

    public AssureDTO( String firstName, String lastName, String email, int tel, int cin, String address, String agence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tel = tel;
        this.cin = cin;
        this.address = address;
        this.agence = agence;
    }
}
