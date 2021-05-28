package mg.jerryharim.activitytracker.cli.repositoryTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Test;

import mg.jerryharim.activitytracker.cli.repository.RepositoryActivite;
import mg.jerryharim.activitytracker.cli.repository.dao.DAOFactory;
import mg.jerryharim.activitytracker.cli.repository.dao.DatabaseManager;
import mg.jerryharim.activitytracker.core.entity.Activite;

import static org.assertj.core.api.BDDAssertions.then;

public class RepositoryActiviteTest {

    @Test
    public void devrait_enregistrer_le_mot_cle_si_introuvable() {

        boolean ajoutOk = ajouterMotCle("productive"); 
        then(ajoutOk).as("Ajout d'une activite si elle est introuvable").isTrue();

    }


    private boolean ajouterMotCle(String motCle) {
        DAOFactory doaFactory = new DAOFactory(DatabaseManager.getInstance().getConnection());
        return doaFactory.getMotCleDAO().ajouter(motCle);
	}

    @Test
    public void devrait_recuperer_l_identifiant_du_mot_cle_si_existe() {
        ajouterMotCle("productive"); 

        DAOFactory doaFactory = new DAOFactory(DatabaseManager.getInstance().getConnection());

        int idMotCle = doaFactory.getMotCleDAO().getByName("productive");
        then(idMotCle).as("l'identifiant devrait etre positif").isGreaterThan(-1);
    }


	@Test
    public void ajout_activite() {
        DAOFactory doaFactory = new DAOFactory(DatabaseManager.getInstance().getConnection());
        RepositoryActivite repositoryActivite = new RepositoryActivite(doaFactory.getActiviteDAO());

        boolean ajoutOk = repositoryActivite.ajouter(new Activite(
            LocalDate.now(),
            LocalTime.now(),
            LocalTime.now(),
            "Une activite",
            new ArrayList<String>()
        ));

        then(ajoutOk).isTrue();
    }

}
