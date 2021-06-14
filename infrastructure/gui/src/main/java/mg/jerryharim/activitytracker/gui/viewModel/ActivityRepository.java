package mg.jerryharim.activitytracker.gui.viewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mg.jerryharim.activitytracker.gui.entity.Activity;


/**
 * Contient la liste des activites utliser par
 * les vues comme point central de donnee
 */
public class ActivityRepository {

    private final ObservableList<Activity> activities = FXCollections.observableArrayList();

    public ObservableList<Activity> getActivities() {
        return activities;
    }

}
