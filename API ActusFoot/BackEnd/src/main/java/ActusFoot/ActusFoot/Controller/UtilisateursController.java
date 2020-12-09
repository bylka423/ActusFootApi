package ActusFoot.ActusFoot.Controller;

import ActusFoot.ActusFoot.Exceptions.ArticleIntrouvableException;
import ActusFoot.ActusFoot.Model.Utilisateurs;
import ActusFoot.ActusFoot.Repositories.IUtilisateurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", maxAge = 3600)
public class UtilisateursController {

    @Autowired
    private IUtilisateurs userRepository;

    //Permet de chercher la liste des utilisateurs
    @GetMapping(value = "/Utilisateurs")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }


    //Permet de chercher la liste des utilisateurs par ID
    @GetMapping(value = "/Utilisateurs/{id}")
    public ResponseEntity findUserById(@PathVariable(name = "idUser") Long idUser){
        if (idUser == null){
            return ResponseEntity.badRequest().body("Erreur utilisateur");
        }
        Utilisateurs utilisateurs = userRepository.getOne(idUser);
        if (utilisateurs == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(utilisateurs);

    }






    //Permet de créer des utilisateurs
    @PostMapping("/Creation")
    public  ResponseEntity createUser(@RequestBody Utilisateurs utilisateurs){
        if (utilisateurs == null){
            return ResponseEntity.badRequest().body("Erreur sur la création");
        }
        Utilisateurs createdUser = userRepository.save(utilisateurs);
        return ResponseEntity.ok(createdUser);
    }


    //Permet de connecter des utilisateurs
    @PostMapping("/Login")
    public ResponseEntity login(@RequestParam(name = "mail") String mail, @RequestParam(name = "password") String password){
        if (StringUtils.isEmpty(mail) || StringUtils.isEmpty(password)){
            return ResponseEntity.badRequest().body("Erreur d'identification");
        }
        Utilisateurs authenticateUser = userRepository.findByMailAndPassword(mail, password);
            if (authenticateUser == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(authenticateUser);
    }






}
