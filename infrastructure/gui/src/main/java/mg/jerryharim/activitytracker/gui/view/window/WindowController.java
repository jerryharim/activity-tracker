package mg.jerryharim.activitytracker.gui.view.window;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import mg.jerryharim.activitytracker.gui.view.Controller;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowController extends Controller implements Initializable  {

    @FXML private VBox childrenContainer;
    private WindowViewModel windowViewModel;

    public WindowController(WindowViewModel windowViewModel) {
        super(windowViewModel);
        this.windowViewModel = windowViewModel;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.windowViewModel.getActivities().addListener((ListChangeListener<Node>) c -> {
            while (c.next()) {
                if (c.wasAdded())
                    c.getAddedSubList().forEach(activity -> {
                        this.childrenContainer.getChildren().add(activity);
                    });
            }
        });
    }

    @FXML
    public void showItems() {
        this.windowViewModel.updateItems();
    }

}
