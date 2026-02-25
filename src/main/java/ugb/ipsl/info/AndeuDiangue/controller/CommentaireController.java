package ugb.ipsl.info.AndeuDiangue.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;
import ugb.ipsl.info.AndeuDiangue.entity.Commentaire;
import ugb.ipsl.info.AndeuDiangue.repository.CommentaireRepository;
import ugb.ipsl.info.AndeuDiangue.service.CommentaireService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/commentaires")
public class CommentaireController {

    private CommentaireRepository commentaireRepository;
    private CommentaireService commentaireService;

    public CommentaireController(CommentaireRepository commentaireRepository,CommentaireService commentaireService){
        this.commentaireRepository=commentaireRepository;
        this.commentaireService=commentaireService;
    }

    @Operation(
            summary = "Listes des commentaires",
            description = "Retourne la listes des commentaires",
            responses = {
                    @ApiResponse(responseCode = "200",description = "La liste des commentaires est retournee")
            }

    )

    @GetMapping
    public List<Commentaire> getAll(){
        return commentaireService.findAll();
    }

    @GetMapping("/{id}")
    public Commentaire getCommentaireById(@PathVariable Long id){
        return commentaireService.findById(id).orElse(null);
    }

    @PostMapping
    public Commentaire creerCommentaire(@RequestBody Commentaire commentaire){
        return commentaireService.update(commentaire);
    }

    @PutMapping
    public Commentaire updateCommentaire(@RequestBody Commentaire commentaire){
        return commentaireRepository.save(commentaire);
    }

    @DeleteMapping("/{id}")
    public void deleteCommentaireById(@PathVariable Long id){
        commentaireService.deleteById(id);
    }

}
