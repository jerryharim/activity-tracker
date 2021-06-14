package mg.jerryharim.activitytracker.gui.view.activityItem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ActivityItemView implements Initializable {

    private final ActivityItemViewModel viewModel;
    @FXML private Label labTitle, labDate;

    public ActivityItemView(ActivityItemViewModel viewModel) {
        this.viewModel = viewModel;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        syncTitle();
        syncDate();
    }

    private void syncTitle() {
        this.labTitle.textProperty().bind(this.viewModel.titleProperty());
    }

    private void syncDate() {
        this.labDate.textProperty().bind(this.viewModel.dateProperty());
    }

}
