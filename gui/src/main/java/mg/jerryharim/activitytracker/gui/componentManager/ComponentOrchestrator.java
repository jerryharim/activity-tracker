package mg.jerryharim.activitytracker.gui.componentManager;

import mg.jerryharim.activitytracker.gui.component.Route;
import mg.jerryharim.activitytracker.gui.component.activiteComponent.ActiviteComponent;
import mg.jerryharim.activitytracker.gui.component.root.RootVM;


/**
 * Defined where et how a component must be
 * displayed.
 */

public class ComponentOrchestrator {
    private final Route route;

    public ComponentOrchestrator(Route route) {
        this.route = route;
    }


    public void show_activities() {
        ActiviteComponent activiteComponent = this.route.create_activite_component();
        activiteComponent.load();

        getRootVM().items().add(activiteComponent.getNode());
    }


    public void show_add_new_activity_component() {
        getRootVM().current_popup().set(
                this.route.get(ComponentName.NOUVELLE_ACTIVITE).getNode());
    }

    private RootVM getRootVM() {
        return (RootVM) this.route.get(ComponentName.ROOT).getViewModel();
    }
}
