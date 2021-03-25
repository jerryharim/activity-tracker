package mg.jerryharim.activitytracker.core.usecase;

import java.util.List;

import mg.jerryharim.activitytracker.core.annotation.Repository;
import mg.jerryharim.activitytracker.core.entity.Activite;

/**
 * Registre qui contient la liste des activites.
 */

 @Repository
public interface RegistreActivite {

    void ajouter(Activite activite);

    List<Activite> recupererTout();

}
