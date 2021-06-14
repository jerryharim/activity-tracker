package mg.jerryharim.activitytracker.gui.view.activityItem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public abstract class ActivityItemViewModel {
    protected StringProperty title = new SimpleStringProperty();
    protected StringProperty date = new SimpleStringProperty();

    public StringProperty titleProperty() {
        return this.title;
    }

    public StringProperty dateProperty() {
        return date;
    }
}
