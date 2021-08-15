package mg.jerryharim.activitytracker.gui.component.nouvelleActivite;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import mg.jerryharim.activitytracker.gui.component.base.View;


public class NouvelleActiviteView extends View<NouvelleActiviteVM> {
    @FXML private Button button_annuler;

    public NouvelleActiviteView(NouvelleActiviteVM nouvelleActiviteVM) {
        super(nouvelleActiviteVM);
    }


    @Override
    public void sync_with_view_model() {
        sync_button_annuler_pressed_state();
    }

    private void sync_button_annuler_pressed_state() {
        this.viewModel.button_annuler_pressed().bind(
                this.button_annuler.pressedProperty());
    }
}
