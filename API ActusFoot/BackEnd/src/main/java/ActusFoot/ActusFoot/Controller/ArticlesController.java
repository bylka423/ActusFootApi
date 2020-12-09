package ActusFoot.ActusFoot.Controller;
import ActusFoot.ActusFoot.Exceptions.ArticleIntrouvableException;
import ActusFoot.ActusFoot.Model.Articles;
import ActusFoot.ActusFoot.Repositories.ArticlesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ArticlesController {

     @Autowired
     private ArticlesDao articlesDao;



     // Permet de récupérer tous les articles
     @GetMapping(value = "/Articles")
     public List<Articles> ListeArticles(){

         return articlesDao.findAll();
     }



     // Permet de récupérer un article par sont ID
    @GetMapping(value = "Article/{id}")
     public Articles afficherArticle(@PathVariable int id)throws ArticleIntrouvableException{

         Articles article = articlesDao.findById(id);

         if (article == null)
             throw new ArticleIntrouvableException("L'article avec l'id " + id + " existe pas");
         return article;
     }



    @DeleteMapping("/Article/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            articlesDao.deleteById((int) id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






     // Permet de créer un article
    @PostMapping(value = "/Articles")
    public ResponseEntity<Void> ajouterArticle(@RequestBody Articles articles){

         Articles articles1 = articlesDao.save(articles);

         if (articles == null){
             return ResponseEntity.noContent().build();
         }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(articles1.getId())
                .toUri();
         return ResponseEntity.created(location).build();
    }




















}
