package ActusFoot.ActusFoot.Repositories;

import ActusFoot.ActusFoot.Model.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUtilisateurs extends JpaRepository<Utilisateurs,Long> {

    Utilisateurs findByMailAndPassword(String mail, String password);





}
