package mg.jerryharim.activitytracker.gui.componentManager;


import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import mg.jerryharim.activitytracker.gui.component.Route;
import mg.jerryharim.activitytracker.gui.component.root.RootComponent;

/**
 * Manage all component.
 */
public class ComponentManager {
    ComponentFactory componentFactory = new ComponentFactory();


    /**
     * Initialize route, load components and initialize
     * synchronisation with their view model
     */
    public void initialize_components() {
        componentFactory.initialize_route();
        componentFactory.build_all();
        componentFactory.initialize_view_model_synchronisations();
    }

    /**
     * Initialize components default states
     */
    public void initialize_defaults() {
        Route route = this.componentFactory.getRoute();

        RootComponent rootComponent = (RootComponent) route.get(ComponentName.ROOT);
        Parent root = (Parent) rootComponent.getNode();

        rootComponent.getViewModel().items().add(new Button("bonjour tous le modne"));
    }

    public Node getRoot_component() {
        return this.componentFactory.getRoute().get(ComponentName.ROOT).getNode();
    }
}
