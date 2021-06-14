package mg.jerryharim.activitytracker.gui.entity;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

public class Activity {

    private final StringProperty title = new SimpleStringProperty("");
    private final ObjectProperty<LocalDateTime> debut = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDateTime> fin = new SimpleObjectProperty<>();

    public Activity(String title, LocalDateTime begin, LocalDateTime end) {
        this.title.set(title);
        this.debut.set(begin);
        this.fin.set(end);
    }


    public StringProperty titleProperty() {
        return title;
    }

    public ObjectProperty<LocalDateTime> debutProperty() {
        return debut;
    }

    public ObjectProperty<LocalDateTime> finProperty() {
        return fin;
    }
}
