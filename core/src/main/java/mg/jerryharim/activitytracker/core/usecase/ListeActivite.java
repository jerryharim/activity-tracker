package mg.jerryharim.activitytracker.core.usecase;

import java.util.List;

import mg.jerryharim.activitytracker.core.annotation.UseCase;
import mg.jerryharim.activitytracker.core.entity.Activite;


@UseCase
public class ListeActivite {

	private final RegistreActivite registreActivite;

	public ListeActivite(RegistreActivite registreActivite) {
		this.registreActivite = registreActivite;
	}


	public List<Activite> recupererTout() {
		return this.registreActivite.recupererTout();
	}

}

