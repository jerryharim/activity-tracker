package mg.jerryharim.activitytracker.gui.component.nouvelleActivite;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import mg.jerryharim.activitytracker.gui.component.base.ViewModel;

public class NouvelleActiviteVM extends ViewModel {
    private final BooleanProperty button_annuler_pressed = new SimpleBooleanProperty();


    @Override
    public void synchronizeStates() {

    }

    @Override
    public void initializeDefaultStates() {

    }


    // getters

    public BooleanProperty button_annuler_pressed() {
        return button_annuler_pressed;
    }
}
