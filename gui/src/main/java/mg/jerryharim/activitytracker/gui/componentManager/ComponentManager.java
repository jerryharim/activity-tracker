package mg.jerryharim.activitytracker.gui.componentManager;


import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import mg.jerryharim.activitytracker.gui.component.Route;
import mg.jerryharim.activitytracker.gui.component.activiteComponent.ActiviteComponent;
import mg.jerryharim.activitytracker.gui.component.root.RootComponent;

/**
 * Manage all component.
 */
public class ComponentManager {
    Route route = new Route();


    /**
     * Initialize route, load components, initialize
     * synchronisation with their view model
     * and initialize defaults states
     */
    public void initialize_components() {
        this.route.initialize();
        this.route.load_all_components();

        initialize_view_model_synchronisations();
        initialize_defaults();
    }

    public void initialize_view_model_synchronisations() {
        this.route.values().forEach(component -> {
            component.getView().sync_with_view_model();
        });
    }

    public void initialize_defaults() {
        RootComponent rootComponent = (RootComponent) this.route.get(ComponentName.ROOT);
        ActiviteComponent activiteComponent = this.route.create_activite_component();
        activiteComponent.load();
        rootComponent.getViewModel().items().add(activiteComponent.getNode());
    }

    public Node getRoot_component() {
        return this.route.get(ComponentName.ROOT).getNode();
    }
}
