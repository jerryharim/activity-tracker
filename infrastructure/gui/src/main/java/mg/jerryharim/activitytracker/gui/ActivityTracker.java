package mg.jerryharim.activitytracker.gui;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mg.jerryharim.activitytracker.gui.viewModel.ActivityRepository;
import mg.jerryharim.activitytracker.gui.viewModel.WindowViewModelImpl;
import mg.jerryharim.activitytracker.gui.view.window.WindowFXMLView;
import mg.jerryharim.activitytracker.gui.view.window.WindowViewModel;

public class ActivityTracker extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WindowViewModel windowViewModel = new WindowViewModelImpl(new ActivityRepository());
        WindowFXMLView windowView = new WindowFXMLView("/fxml/fenetre.fxml", windowViewModel);

//        ActivityItemViewModel activityItemViewModel = new ActivityItemViewModelImpl();

        windowView.load();
        Node root = windowView.getNode();


        primaryStage.setTitle("ActivityTracker");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene((Parent) root));
        primaryStage.show();
    }
}