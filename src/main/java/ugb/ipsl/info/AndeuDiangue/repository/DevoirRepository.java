package ugb.ipsl.info.AndeuDiangue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ugb.ipsl.info.AndeuDiangue.entity.Devoir;

import java.util.List;
import java.util.Optional;

public interface DevoirRepository extends JpaRepository<Devoir,Long> {
    @Override
    Optional<Devoir> findById(Long aLong);
    List<Devoir> findAll();


//    Optional<Devoir> findByEmail(String email);
}


