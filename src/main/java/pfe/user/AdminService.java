package pfe.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pfe.agence.Agence;
import pfe.agence.AgenceDTO;
import pfe.agence.AgenceRepository;
import pfe.role.Role;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminService {
    private final AgenceRepository repository;

    public List<AgenceDTO> getAllUsers() {
        List<Agence> users = repository.findAll();
        return users.stream()
                .map(user -> new AgenceDTO(user.getId(),
                        user.getEmail(),
                        user.getName(),
                        user.getMatricule(),
                        user.getTel(),
                        user.getFile(),
                        user.getAddress(),
                        user.getStatus()))
                .collect(Collectors.toList());
    }
    public void activateAgence(String name) {
        Agence agence = repository.findByName(name);
        agence.setStatus("active");
        repository.save(agence);
    }
}
