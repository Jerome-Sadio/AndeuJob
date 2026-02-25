package ugb.ipsl.info.AndeuDiangue.entity;
import jakarta.persistence.*;
import lombok.*;
//import jakarta.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Devoir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDevoir;

    @Column(length = 30, nullable = false)
    private String nomDevoir;

    @Column(length = 75, nullable = false)
    private String nomMatiere;

    @Column(length = 100,nullable = false)
//    @JoinColumn()
    private String nomProf;

//    @NotBlank(message="Email can't be empty")
    @Column(name = "email", length = 150, nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Date dateCreation;

    @Column(nullable = false)
    private LocalDateTime dateLimite;

}
