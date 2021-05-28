package mg.jerryharim.activitytracker.cli;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import mg.jerryharim.activitytracker.core.entity.Activite;
import mg.jerryharim.activitytracker.core.usecase.EnregistrementActivite;
import mg.jerryharim.activitytracker.core.usecase.ListeActivite;
import mg.jerryharim.activitytracker.core.utility.DateTimeUtility;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

/**
 * A faire :
 * -----
 *  - detail
 */

@Command(
    name = "ajout",
    version = "1.0",
    description = "Ajout d'une nouvelle activite",
    mixinStandardHelpOptions = true
)
public class CommandeAjoutActivite implements Callable<Integer> {

    @Option(names = {"-j"}, description = "Date de commencement de l'activité")
    private String optionDateDebut;

    @Option(names = {"-e"}, description = "Date de fin de l'activité")
    private String optionDateFin;

    @Option(names = {"-d"}, description = "Heure de commencement de l'activité")
    private String optionHeureDebut;

    @Option(names = {"-f"}, description = "Heure de fin de l'activité")
    private String optionHeureFin;

    @Option(names = {"-n"}, description = "Nom de l'activité")
    private String nom;

    @Option(names = {"-m"}, description = "Mots cles de l'activité")
    private String optionMotCles;

    private LocalDate dateDebut, dateFin;
    private LocalTime heureDebut, heureFin;
    private List<String> motCles;

    private final EnregistrementActivite enregistrementActivite;
    private final ListeActivite listeActivite;


    public CommandeAjoutActivite(EnregistrementActivite enregistrementActivite, ListeActivite listeActivite) {
        this.enregistrementActivite = enregistrementActivite;
        this.listeActivite = listeActivite;
    }


    @Override
    public Integer call() throws Exception {
        this.dateDebut = DateTimeUtility.toDayMonthYear(this.optionDateDebut);
        this.dateFin = DateTimeUtility.toDayMonthYear(this.optionDateFin);
        this.heureDebut = DateTimeUtility.toHourOfDay(this.optionHeureDebut);
        this.heureFin = DateTimeUtility.toHourOfDay(this.optionHeureFin);
        this.motCles = split(this.optionMotCles);

        this.enregistrementActivite.enregistrer(dateDebut, dateFin, heureDebut, heureFin, this.nom, this.motCles);
        showListeActivite(listeActivite);

        return 0;
    }

    private void showListeActivite(ListeActivite listeActivite) {
        System.out.println("===========================");
        System.out.println("= Liste des activite      =");
        System.out.println("===========================");

        listeActivite.recupererTout().forEach(activite -> {
            afficherMessageDateActivite(activite);
            afficherTitre(activite);
            afficherDetailSiExiste(activite);
            afficherMotCles(activite);

            System.out.println("");
        });
    }


	private void afficherTitre(Activite activite) {
        System.out.printf("Activité : %s%n", activite.getNom());
	}

	private void afficherDetailSiExiste(Activite activite) {
        if (!activite.getDetail().equals(null))
            System.out.printf("Plus de detail : %s%n", activite.getDetail());
	}

    private void afficherMotCles(Activite activite) {
        System.out.printf("Mot cles : %s%n", activite.getMotCle());
	}

	private void afficherMessageDateActivite(Activite activite) {
        String dateMessage = String.format("Le %s ", activite.getDateDebut());
        if (activite.getDateFin() != null && !activite.getDateDebut().equals(activite.getDateFin()))
            dateMessage += String.format("Jusqu'au %s, ", activite.getDateDebut());
        dateMessage += String.format("de %s à %s %n", activite.getHeureDebut(), activite.getHeureFin());

        System.out.println(dateMessage);
	}


	private List<String> split(String strCSVFormat) {
        List<String> all = new ArrayList<>();
        for (String element : strCSVFormat.split(",")) all.add(element);
        return all;
    }

    public LocalDate getDate() {
        return this.dateDebut;
    }

    public LocalTime getHeureDebut() {
        return this.heureDebut;
    }

    public LocalTime getHeureFin() {
        return this.heureFin;
    }

    public String getNom() {
        return this.nom;
    }

    public List<String> getMotCles() {
        return this.motCles;
    }

}
