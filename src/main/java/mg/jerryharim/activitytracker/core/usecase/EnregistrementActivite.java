package mg.jerryharim.activitytracker.core.usecase;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import mg.jerryharim.activitytracker.core.annotation.UseCase;
import mg.jerryharim.activitytracker.core.entity.Activite;


@UseCase
public class EnregistrementActivite {

	private RegistreActivite registreActivite;

	public EnregistrementActivite(RegistreActivite registreActivite) {
		this.registreActivite = registreActivite;
	}


	public void enregistrer(LocalDate date, LocalTime heureDebut, LocalTime heureFin, String nom, String motCle) {
		List<String> listMotCle = new ArrayList<>();
		listMotCle.add(motCle);
		enregistrer(date, heureDebut, heureFin, nom, listMotCle, null);
	}

    public void enregistrer(LocalDate date, LocalTime heureDebut, LocalTime heureFin, String nom,
            List<String> listMotCles, String detail) {
		Activite activite = new Activite(date, heureDebut, heureFin, nom, listMotCles);
		activite.setDetail(detail);
		this.registreActivite.ajouter(activite);
    }

    public void enregistrer(LocalDate dateDebut, LocalDate dateFin, LocalTime heureDebut, LocalTime heureFin, String nom,
            List<String> listMotCles) {
		Activite activite = new Activite(dateDebut, dateFin, heureDebut, heureFin, nom, listMotCles);
		this.registreActivite.ajouter(activite);
    }

}


