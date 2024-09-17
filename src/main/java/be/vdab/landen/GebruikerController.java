package be.vdab.landen;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class GebruikerController {
    GebruikerController() throws IOException {
        var homeDirectory = Path.of(System.getProperty("user.home"));
        var bestand = homeDirectory.resolve("organisatie.txt");
        if (!Files.exists(bestand)) {
            Files.writeString(bestand, "VDAB");
            System.out.println(bestand + " gemaakt");
        }
    }

    public record User (String username){}

    @GetMapping("/user")
    public ResponseEntity<User> getUser() {
        return ResponseEntity.ok(new User(System.getProperty("user.name")));
    }
}
