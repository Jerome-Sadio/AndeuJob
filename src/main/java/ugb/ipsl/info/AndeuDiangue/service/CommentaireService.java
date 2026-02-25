package ugb.ipsl.info.AndeuDiangue.service;

import org.springframework.stereotype.Service;
import ugb.ipsl.info.AndeuDiangue.entity.Commentaire;
import ugb.ipsl.info.AndeuDiangue.repository.CommentaireRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService {

    private CommentaireRepository commentaireRepository;

    public CommentaireService(CommentaireRepository commentaireRepository){
        this.commentaireRepository=commentaireRepository;
    }

    public Optional<Commentaire> findById(Long id){
        return commentaireRepository.findById(id);
    }

    public List<Commentaire> findAll(){
        return commentaireRepository.findAll();
    }

    public Commentaire create (Commentaire commentaire) throws ApiError {
        if (commentaire.getAuteur()==null || commentaire.getAuteur().isBlank()){
            throw new ApiError(401,"l'auteur est obligatoire");
        }

        if (commentaire.getContenu()==null || commentaire.getContenu().isBlank()){
            throw new ApiError(401,"Le commentaire est obligatoire");
        }

        return commentaireRepository.save(commentaire);
    }

    public void delete(Commentaire commentaire){
        commentaireRepository.delete(commentaire);
    }

    public void deleteById(Long id){
        commentaireRepository.deleteById(id);
    }

    public Commentaire update(Commentaire commentaire){
        return commentaireRepository.save(commentaire);
    }
}
