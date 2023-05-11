package pfe.agence;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import pfe.Expert.ExpertRegisterRequest;
import pfe.Expert.ExpertService;
import pfe.files.message.ResponseMessage;
import pfe.files.model.FileInfo;
import pfe.files.service.FilesStorageService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@PreAuthorize("hasRole('AGENCE')")
@RequestMapping("/api/v1/management")
@Tag(name = "Management")
public class AgenceController {
    private final AgenceService service;
    private final ExpertService expertService;
    private final AgenceRepository agenceRepository;
    private final FilesStorageService storageService;

    @Operation(
            description = "Get endpoint for agency management",
            summary = "This is a summary for agency get endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    /*@GetMapping("/{id}")
    public ResponseEntity<?> getAgence(@RequestParam("id") Integer id){
        Optional<User> agence = service.getAgence(id);
        return new ResponseEntity<>(agence, HttpStatus.OK);
    }*/
/*
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("name") String name) {
        String message = "";
        Agence agence = repository.findByName(name);
        try {
            Fi files = service.saveImage(file);
            for (int i = 0; i < files.size(); i++) {
                message = "Uploaded the file successfully: " + file[i].getOriginalFilename();
            }
            agence.setFile(files);
            repository.save(agence);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the files !";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }*/

  /*  @PostMapping(value = {"/upload"})
    public void addFile( @RequestParam("file") MultipartFile file,@RequestParam("name") String name ) throws IOException {
        Path filePath =  service.saveFile(file);
        Agence agence = repository.findByName(name);
        agence.setFile(String.valueOf(filePath));
        agence.setStatus("accepted");
        repository.save(agence);
    }*/


    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("name") String name) {
        String message = "";
        try {
            storageService.save(file);
            Agence agence = agenceRepository.findByName(name);
            agence.setFile(file.getOriginalFilename());
            agenceRepository.save(agence);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }



    @PostMapping("/add/expert")
    public ResponseEntity<?> addExpert(@RequestBody ExpertRegisterRequest request,@RequestParam("id") Integer id){
        return new ResponseEntity<>(expertService.saveExpert(request,id), HttpStatus.OK);
    }

    @GetMapping ("/users")
    public ResponseEntity<?> getUsers(@RequestParam("name") String name) {
        return new ResponseEntity<>(service.getAllAssure(name), HttpStatus.OK);
    }

   /*@GetMapping ("/files")
    public ResponseEntity<?> getFile(@RequestParam("id") Integer id) {
        return new ResponseEntity<>(service.getFile(id), HttpStatus.OK);
    }*/
    @DeleteMapping
    public String delete() {
        return "DELETE:: agency management controller";
    }
}
