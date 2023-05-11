package pfe.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pfe.Assuré.AssureDTO;
import pfe.Expert.ExpertDTO;
import pfe.agence.AgenceDTO;
import pfe.role.Role;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationResponse {

  @JsonProperty("access_token")
  private String accessToken;
  @JsonProperty("id")
  private Integer id;
  @JsonProperty("Role")
  private Role role;
  @JsonProperty("message")
  private String message;
  @JsonProperty("agence")
  private  AgenceDTO agence;
  @JsonProperty("user")
  private  AssureDTO assure;
  @JsonProperty("expert")
  private ExpertDTO expert;
  @JsonProperty("admin")
  private UserDTO admin;


  public AuthenticationResponse(Integer id,String accessToken, AgenceDTO agence, Role role) {
    this.id = id;
   this.role = role;
    this.accessToken = accessToken;
    this.agence = agence;
  }
  public AuthenticationResponse(Integer id,String accessToken, AssureDTO assure, Role role) {
    this.id = id;

    this.role = role;
    this.accessToken = accessToken;
    this.assure = assure;
  }
    public AuthenticationResponse(Integer id,String accessToken, ExpertDTO expert, Role role) {
      this.id = id;

      this.role = role;
        this.accessToken = accessToken;
        this.expert = expert;
    }
  public AuthenticationResponse(Integer id,String accessToken, UserDTO admin, Role role) {
    this.id = id;

    this.role = role;
    this.accessToken = accessToken;
    this.admin = admin;
  }

}
