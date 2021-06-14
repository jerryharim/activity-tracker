package mg.jerryharim.activitytracker.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import mg.jerryharim.activitytracker.gui.entity.Activity;
import mg.jerryharim.activitytracker.gui.view.activityItem.ActivityItemView;
import mg.jerryharim.activitytracker.gui.view.activityItem.ActivityItemViewModel;
import mg.jerryharim.activitytracker.gui.viewModel.ActivityItemViewModelImpl;
import mg.jerryharim.activitytracker.gui.view.window.WindowController;
import mg.jerryharim.activitytracker.gui.view.window.WindowViewModel;

import java.io.IOException;

/**
 * Responsable de la creation des vues
 */
public class ViewBuilder {

    private final ViewModelFactory viewModeFactory;

    public ViewBuilder(ViewModelFactory viewModelFactory) {
        this.viewModeFactory = viewModelFactory;
    }

    public Parent createWindowView(WindowViewModel windowViewModel){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/fenetre.fxml"));
        loader.setController(new WindowController(windowViewModel));

        try {
            return loader.load();
        } catch (IOException e) {
            System.exit(1);
            return null;
        }
    }

    public Pane createActivityItemView(Activity activity) {
        ActivityItemViewModel viewModel = new ActivityItemViewModelImpl(activity);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/item-activite.fxml"));
        loader.setController(new ActivityItemView(viewModel));

        try {
            return loader.load();
        } catch (IOException e) {
            System.exit(1);
            return null;
        }
    }
}
