package ugb.ipsl.info.AndeuDiangue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ugb.ipsl.info.AndeuDiangue.entity.Commentaire;

import java.util.Optional;

public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {

    @Override
    Optional<Commentaire> findById(Long aLong);
}
