package mg.jerryharim.activitytracker.core.stepdefs;

import static org.assertj.core.api.BDDAssertions.then;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.cucumber.java.Before;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import mg.jerryharim.activitytracker.core.entity.Activite;
import mg.jerryharim.activitytracker.core.fakeRepository.FakeRegistreActivite;
import mg.jerryharim.activitytracker.core.usecase.EnregistrementActivite;
import mg.jerryharim.activitytracker.core.usecase.ListeActivite;
import mg.jerryharim.activitytracker.core.utility.DateTimeUtility;



public class EnregistrementActiviteStepDefs {
    EnregistrementActivite enregistrementActivite;
    private LocalDate date;
    private LocalTime heureDebut, heureFin;
    private String nom;
    private ListeActivite listeActivite;
    private List<String> motCles;
    private String detail;
    private Activite activiteEnregistrer;

    @Before
    public void setup() {
        FakeRegistreActivite fakeRegistreActivite = new FakeRegistreActivite();
        this.enregistrementActivite = new EnregistrementActivite(fakeRegistreActivite);
        this.listeActivite = new ListeActivite(fakeRegistreActivite);
    }


    @Etantdonnéque("j'ai {string} le {string} de {string} à {string}")
    public void existance_nouvelle_activite(String nomActivite, String date, String heureDebut, String heureFin) {

        this.date = DateTimeUtility.toDayMonthYear(date);
        this.heureDebut = DateTimeUtility.toHourOfDay(heureDebut);
        this.heureFin = DateTimeUtility.toHourOfDay(heureFin);
        this.nom = nomActivite;
    }

    @Quand("je l'enregistre avec comme cle {string}")
    public void je_l_enregistre_avec_comme_cle( String motCle) {

        this.motCles = split(motCle);
        this.enregistrementActivite.enregistrer(
            this.date,
            this.heureDebut,
            this.heureFin,
            this.nom,
            motCle
        );

    }

    @Alors("l'activité suivant devrait exister dans mes activités")
    public void l_activite_suivant_devrait_exister_dans_mes_activites(final List<Map<String, String>> activite) {

        this.activiteEnregistrer = this.listeActivite.recupererTout().get(0);

        activite.forEach(detailActivite -> {
            then(activiteEnregistrer.getDate()).isEqualTo(this.date);
            then(activiteEnregistrer.getHeureDebut()).isEqualTo(this.heureDebut);
            then(activiteEnregistrer.getHeureFin()).isEqualTo(this.heureFin);
            then(activiteEnregistrer.getNom()).isEqualTo(this.nom);
            then(activiteEnregistrer.getMotCle()).containsAll(this.motCles);
        });

    }

    @Quand("je le dataille avec la phrase : {string}")
    public void je_le_dataille_avec_la_phrase(final String detailActivite) {
        this.detail = detailActivite;
    }

    @Et("l'enregistre avec comme cles {string}")
    public void l_enregistre_avec_comme_cles(final String motCles) {

        this.motCles = split(motCles);
        this.enregistrementActivite.enregistrer(
            this.date,
            this.heureDebut,
            this.heureFin,
            this.nom,
            this.motCles, 
            this.detail
        );

    }

    private List<String> split(String motCles) {
        List<String> listMotCles = new ArrayList<>();
        for (String motCle : motCles.split(",")) listMotCles.add(motCle.trim());
        return listMotCles;
    }


    @Et("qui devrait avoir comme detail : {string}")
    public void qui_devrait_avoir_comme_detail(String detailEsperer) {

        then(this.activiteEnregistrer.getDetail())
            .isEqualTo(detailEsperer);

    }

}
