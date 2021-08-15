package mg.jerryharim.activitytracker.gui.component.root;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import mg.jerryharim.activitytracker.gui.component.base.ViewModel;


public class RootVM extends ViewModel {
    private final BooleanProperty pressed_close_button = new SimpleBooleanProperty();
    private final ObjectProperty<Node> current_popup = new SimpleObjectProperty<>();
    private final ObservableList<Node> items = FXCollections.observableArrayList();


    @Override
    public void synchronizeStates() {

    }

	@Override
    public void initializeDefaultStates() {

    }


    // getters

    public ObservableList<Node> items() {
		return items;
	}

    public BooleanProperty pressed_close_button() {
        return pressed_close_button;
    }

    public ObjectProperty<Node> current_popup() {
        return current_popup;
    }
}
