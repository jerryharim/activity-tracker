package mg.jerryharim.activitytracker.cli.repository;

import java.util.ArrayList;
import java.util.List;

import mg.jerryharim.activitytracker.core.entity.Activite;
import mg.jerryharim.activitytracker.core.usecase.RegistreActivite;

public class FakeRegistreActivite implements RegistreActivite {
    List<Activite> activites = new ArrayList<>();

    @Override
    public boolean ajouter(Activite activite) {
        return this.activites.add(activite);
    }

    @Override
    public List<Activite> recupererTout() {
        return this.activites;
    }

}
