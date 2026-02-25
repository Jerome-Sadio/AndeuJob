package ugb.ipsl.info.AndeuDiangue.service;

import org.springframework.stereotype.Service;
import ugb.ipsl.info.AndeuDiangue.entity.Devoir;
import ugb.ipsl.info.AndeuDiangue.repository.DevoirRepository;

import java.util.List;

@Service
public class DevoirService {

    private final DevoirRepository repoDevoir;

    public DevoirService(DevoirRepository repoDevoir) {
        this.repoDevoir = repoDevoir;
    }

    // Devoir disponibles
    public List<Devoir> getDevoir(){
        return repoDevoir.findAll();
    }

    // Chercher un devoir par son identifiant
    public Devoir getDevoir(Long along){
        return repoDevoir.findById(along).orElse(new Devoir());
    }

    // Ajouter un devoir
    public void addDevoir(Devoir devoir){
        repoDevoir.save(devoir);
    }

}
