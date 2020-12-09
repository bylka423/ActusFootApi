package ActusFoot.ActusFoot.Repositories;
import ActusFoot.ActusFoot.Model.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesDao extends JpaRepository<Articles, Integer> {

    Articles findById(int id);


}
