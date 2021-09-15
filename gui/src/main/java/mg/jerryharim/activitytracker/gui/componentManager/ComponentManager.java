package mg.jerryharim.activitytracker.gui.componentManager;


import javafx.scene.Node;
import mg.jerryharim.activitytracker.gui.component.Route;
import mg.jerryharim.activitytracker.gui.eventManager.ComponentEventManager;

/**
 * Manage all component.
 */
public class ComponentManager {
    private final Route route;
    private final ComponentOrchestrator component_orchestrator;
    private final ComponentEventManager component_event_manager;

    public ComponentManager() {
        this.route = new Route();
        this.component_orchestrator = new ComponentOrchestrator(this.route);
        this.component_event_manager = new ComponentEventManager(this.route,
                this.component_orchestrator);
    }


    /**
     * Initialize route, load components, initialize
     * synchronisation with their view model
     * and initialize defaults states
     */
    public void initialize_components() {
        System.out.println("[1]. Initialize components...");

        this.route.initialize();
        this.route.load_all_components();

        System.out.printf("done%n[2]. Initializing events...%n");
        this.component_event_manager.initialize();

        initialize_defaults();
    }

    public void initialize_defaults() {
        System.out.println("8. Show default activites ...");
        this.component_orchestrator.show_activities();
    }

    public Node getRoot_component() {
        return this.route.get(ComponentName.ROOT).getNode();
    }
}
