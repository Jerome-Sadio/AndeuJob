package ugb.ipsl.info.AndeuDiangue.entity;// package ugb.ipsl.info.andeudiangue.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String nom;

    @Column(unique = true, nullable = false)
    private String matricule;           // ex: GIT2025123

    @Column(unique = true, nullable = false)
    private String email;               // ex: prenom.nom@acad.sn

    private String password;            // en clair pour l'instant (à sécuriser plus tard)

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles")
    private Set<Role> roles = new HashSet<>();
}