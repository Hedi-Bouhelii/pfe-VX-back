package pfe.user;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@NoArgsConstructor
public class AgenceResponces {
    private String email;
    private String name;
    private String matricule;
    private int tel;
    private String address;
    private boolean enabled;


}
