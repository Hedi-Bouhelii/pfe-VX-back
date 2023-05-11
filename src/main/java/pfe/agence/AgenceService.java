package pfe.agence;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pfe.Assuré.Assure;
import pfe.Assuré.AssureRepository;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AgenceService  {
    private final AgenceRepository agenceRepository;
    private final AssureRepository assureRepository;

    public List<Assure> getAllAssure(String name) {
        return assureRepository.findAllByAgence(name);
    }
    public Path saveFile(MultipartFile file) throws IOException {
        String folder = "/home/ahmed/Desktop/pfe/";
        byte[] bytes = file.getBytes();
        Path path = Paths.get(folder +file.getOriginalFilename());
        Files.write(path,bytes);
        return path;
    }

}
