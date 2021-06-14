package mg.jerryharim.activitytracker.gui.view.window;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import mg.jerryharim.activitytracker.gui.view.ViewModel;

public abstract class WindowViewModel extends ViewModel {

    protected ObservableList<Node> activities = FXCollections.observableArrayList();


    public abstract void updateItems();

    public ObservableList<Node> getActivities() {
        return activities;
    }
}
