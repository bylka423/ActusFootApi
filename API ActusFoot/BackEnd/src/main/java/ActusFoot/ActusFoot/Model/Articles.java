package ActusFoot.ActusFoot.Model;
import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;


@Entity
public class Articles {

    @Id
    @GeneratedValue
    private int id;
    private String pagepincipal;
    private String titre;
    private String contenu;
    private Date date;

    //@Lob
    private byte[] image;

    private String journaliste;
    private String pays;
    private String competition;
    private String club;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Utilisateurs utilisateurs;


    //Constructeur par défault
    public Articles(){

    }


    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPagepincipal() {
        return pagepincipal;
    }

    public void setPagepincipal(String pagepincipal) {
        this.pagepincipal = pagepincipal;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getJournaliste() {
        return journaliste;
    }

    public void setJournaliste(String journaliste) {
        this.journaliste = journaliste;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public Utilisateurs getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Utilisateurs utilisateurs) {
        this.utilisateurs = utilisateurs;
    }


    @Override
    public String toString() {
        return "Articles{" +
                "id=" + id +
                ", pagepincipal='" + pagepincipal + '\'' +
                ", titre='" + titre + '\'' +
                ", contenu='" + contenu + '\'' +
                ", date=" + date +
                ", image=" + Arrays.toString(image) +
                ", journaliste='" + journaliste + '\'' +
                ", pays='" + pays + '\'' +
                ", competition='" + competition + '\'' +
                ", club='" + club + '\'' +
                ", utilisateurs=" + utilisateurs +
                '}';
    }
}
