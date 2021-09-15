package mg.jerryharim.activitytracker.gui.eventManager;

import mg.jerryharim.activitytracker.gui.component.Route;
import mg.jerryharim.activitytracker.gui.component.nouvelleActivite.NouvelleActiviteVM;
import mg.jerryharim.activitytracker.gui.component.root.RootVM;
import mg.jerryharim.activitytracker.gui.componentManager.ComponentName;
import mg.jerryharim.activitytracker.gui.componentManager.ComponentOrchestrator;

/**
 * Manage event in all component.
 */
public class ComponentEventManager {

    private final Route route;
    private final ComponentOrchestrator component_orchestrator;

    private RootComponentEventManager root_component_event_manager;
    private NouvelleActiviteComponentEventManager nouvelle_activite_event_manager;

    public ComponentEventManager(Route route, ComponentOrchestrator component_orchestrator) {
        this.route = route;
        this.component_orchestrator = component_orchestrator;
    }


    /**
     * Initialize all events listeners.
     * Call this only after all components is loaded.
     */
    public void initialize() {
        System.out.println("[4]. Initialize event...");

        this.root_component_event_manager = new RootComponentEventManager(
                getRootComponentVM(), component_orchestrator);

        this.nouvelle_activite_event_manager = new NouvelleActiviteComponentEventManager(
                getNouvelleComponentVM(), component_orchestrator);

        listen_all();
    }

    private void listen_all() {
        this.root_component_event_manager.listen_all();
        this.nouvelle_activite_event_manager.listen_all();
    }

    private RootVM getRootComponentVM() {
        return (RootVM) this.route.get(ComponentName.ROOT).getViewModel();
    }

    private NouvelleActiviteVM getNouvelleComponentVM() {
        return (NouvelleActiviteVM) this.route.get(ComponentName.NOUVELLE_ACTIVITE).getViewModel();
    }


}
