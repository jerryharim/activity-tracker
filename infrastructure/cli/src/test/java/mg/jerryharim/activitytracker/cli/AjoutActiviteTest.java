package mg.jerryharim.activitytracker.cli;

import static org.assertj.core.api.BDDAssertions.then;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import picocli.CommandLine;

public class AjoutActiviteTest {

    @Test
    public void devrait_pouvoir_recuperer_les_options() {
        // Given
        String date = "10-03-2021"; 
        String heureDebut = "04:30"; 
        String heureFin = "07:00"; 
        String nom = "cours sur gradle";
        String motCles = "lecture, gradle, tres productive";

        String[] arguments = {
            "-j", date,
            "-d", heureDebut, 
            "-f", heureFin,
            "-n", nom,
            "-m", motCles
        };

        // when
        CommandeAjoutActivite ajoutActivite = CommandLine.populateCommand(new CommandeAjoutActivite(), arguments);

        // then
        String dateEsperer = ajoutActivite.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String heureDebutEseperer = ajoutActivite.getHeureDebut().format(DateTimeFormatter.ofPattern("HH:mm"));
        String heureFinEsperer = ajoutActivite.getHeureFin().format(DateTimeFormatter.ofPattern("HH:mm"));
        String nomEsperer = ajoutActivite.getNom();
        List<String> listeMotClesEsperer = ajoutActivite.getMotCles();

        then(dateEsperer).isEqualTo(date);
        then(heureDebutEseperer).isEqualTo(heureDebut);
        then(heureFinEsperer).isEqualTo(heureFin);
        then(nomEsperer).isEqualTo(nom);
        then(listeMotClesEsperer).containsAll(split(motCles));
    }

    private List<String> split(String motCles) {
        List<String> all = new ArrayList<>();
        for (String motCle : motCles.split(",")) all.add(motCle);
        return all;
    }
}
