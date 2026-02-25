package ugb.ipsl.info.AndeuDiangue.controller;// package ugb.ipsl.info.andeudiangue.controller;

import ugb.ipsl.info.AndeuDiangue.entity.Role;
import ugb.ipsl.info.AndeuDiangue.entity.User;
import ugb.ipsl.info.AndeuDiangue.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    // Création simple (inscription sans sécurité pour l'instant)
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserCreateDTO dto) {

        if (userRepository.existsByEmail(dto.email())) {
            return ResponseEntity.badRequest().body(null); // ou throw exception
        }
        if (userRepository.existsByMatricule(dto.matricule())) {
            return ResponseEntity.badRequest().body(null);
        }

        User user = User.builder()
                .prenom(dto.prenom())
                .nom(dto.nom())
                .matricule(dto.matricule())
                .email(dto.email())
                .password(dto.password())           // en clair → à changer plus tard
                .roles(Set.of(Role.ETUDIANT))       // rôle par défaut
                .build();

        User saved = userRepository.save(user);
        return ResponseEntity.ok(saved);
    }

    // Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Récupérer par email (utile pour login futur)
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Liste tous les utilisateurs (pour debug / admin)
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Optionnel : mise à jour rôle (ex: promouvoir délégué)
    @PatchMapping("/{id}/role")
    public ResponseEntity<User> addRole(@PathVariable Long id, @RequestBody RoleUpdateDTO dto) {
        return userRepository.findById(id)
                .map(user -> {
                    user.getRoles().add(dto.role());
                    return ResponseEntity.ok(userRepository.save(user));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}


record UserCreateDTO(
        String prenom,
        String nom,
        String matricule,
        String email,
        String password
) {}

record RoleUpdateDTO(Role role) {}