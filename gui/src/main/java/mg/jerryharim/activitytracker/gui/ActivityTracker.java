package mg.jerryharim.activitytracker.gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import mg.jerryharim.activitytracker.gui.component.Route;
import mg.jerryharim.activitytracker.gui.component.root.RootComponent;
import mg.jerryharim.activitytracker.gui.componentManager.ComponentFactory;
import mg.jerryharim.activitytracker.gui.componentManager.ComponentManager;
import mg.jerryharim.activitytracker.gui.componentManager.ComponentName;


public class ActivityTracker extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        ComponentManager componentManager = new ComponentManager();
        componentManager.initialize_components();
        componentManager.initialize_defaults();

        Parent root = (Parent) componentManager.getRoot_component();

        stage.setTitle("Activity tracker");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
