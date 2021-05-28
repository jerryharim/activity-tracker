package mg.jerryharim.activitytracker.cli.repository;

import java.util.List;

import mg.jerryharim.activitytracker.cli.repository.dao.ActiviteDAO;
import mg.jerryharim.activitytracker.core.entity.Activite;
import mg.jerryharim.activitytracker.core.usecase.RegistreActivite;

public class RepositoryActivite implements RegistreActivite {

    private final ActiviteDAO activiteDAO;

    public RepositoryActivite(ActiviteDAO activiteDAO) {
        this.activiteDAO = activiteDAO;
    }

    @Override
    public boolean ajouter(Activite activite) {
        return this.activiteDAO.ajouter(activite) > 0;
    }

    @Override
    public List<Activite> recupererTout() {
        return this.activiteDAO.recupererTout();
    }

}
