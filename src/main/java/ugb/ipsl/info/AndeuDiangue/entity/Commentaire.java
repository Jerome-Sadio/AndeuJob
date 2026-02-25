package ugb.ipsl.info.AndeuDiangue.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,length = 90)
    private String contenu;

    @Column(nullable = false,length = 20)
    private String auteur;

    private LocalDateTime dateCreation;

    private LocalDateTime dateModification;

   // @ManyToOne
    //@JoinColumn(name = "devoir_id")
    //private Devoir devoir;
}
