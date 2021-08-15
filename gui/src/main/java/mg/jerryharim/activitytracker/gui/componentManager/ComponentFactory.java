package mg.jerryharim.activitytracker.gui.componentManager;

import mg.jerryharim.activitytracker.gui.component.Route;
import mg.jerryharim.activitytracker.gui.component.activiteComponent.ActiviteComponent;
import mg.jerryharim.activitytracker.gui.component.activiteComponent.ActiviteVM;
import mg.jerryharim.activitytracker.gui.component.activiteComponent.ActiviteView;
import mg.jerryharim.activitytracker.gui.component.base.Component;
import mg.jerryharim.activitytracker.gui.component.nouvelleActivite.NouvelleActiviteComponent;
import mg.jerryharim.activitytracker.gui.component.nouvelleActivite.NouvelleActiviteVM;
import mg.jerryharim.activitytracker.gui.component.nouvelleActivite.NouvelleActiviteView;
import mg.jerryharim.activitytracker.gui.component.root.RootComponent;
import mg.jerryharim.activitytracker.gui.component.root.RootVM;
import mg.jerryharim.activitytracker.gui.component.root.RootView;


public class ComponentFactory {


    public RootComponent create_root_component() {
        return new RootComponent(
                "/fxml/liste_activite.fxml",
                new RootView(new RootVM())
        );
    }

    public NouvelleActiviteComponent create_nouvelle_activite_component() {
        return new NouvelleActiviteComponent(
                "/fxml/nouvelle-activite.fxml",
                new NouvelleActiviteView(new NouvelleActiviteVM())
        );
    }

    public ActiviteComponent create_activite_component() {
        return new ActiviteComponent(
                "/fxml/item-activite.fxml",
                new ActiviteView(new ActiviteVM())
        );
    }

}
